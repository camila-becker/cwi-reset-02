package br.com.cwi.resetflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ator.AtorEntityMapper;
import br.com.cwi.resetflix.mapper.ator.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.ator.ConsultarDetalhesAtorResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarAtorRequest;
import br.com.cwi.resetflix.response.ator.AtoresResponse;
import br.com.cwi.resetflix.response.ator.ConsultarDetalhesAtorResponse;

@Service
public class AtoresService {

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private FilmesRepository filmesRepository;

    static AtoresResponseMapper MAPPER_RESPONSE = new AtoresResponseMapper();
    static AtorEntityMapper MAPPER_ENTITY = new AtorEntityMapper();
    static ConsultarDetalhesAtorResponseMapper MAPPER_DETALHES_ATOR = new ConsultarDetalhesAtorResponseMapper();

    public List<AtoresResponse> getAtores() {
        final List<AtorEntity> atores = atoresRepository.getAtores();
        return MAPPER_RESPONSE.mapear(atores);
    }

    public Long criarAtor(final CriarAtorRequest request) {
        AtorEntity salvarAtor = MAPPER_ENTITY.mapear(request);
        return atoresRepository.criarAtor(salvarAtor);
    }

    public ConsultarDetalhesAtorResponse consultarDetalhesAtor(final Long id) {
        AtorEntity atorSalvo = atoresRepository.buscarAtorPorId(id);
        List<FilmeEntity> filmesAtor = filmesRepository.acharFilmesAtor(id);
        return MAPPER_DETALHES_ATOR.mapear(atorSalvo, filmesAtor);
    }
}
