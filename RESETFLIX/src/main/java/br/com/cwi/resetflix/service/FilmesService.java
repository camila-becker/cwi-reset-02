package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.FilmesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.FilmeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmesService {
    @Autowired
    private FilmesRepository filmesRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    @Autowired
    private DiretoresRepository diretoresRepository;

    static FilmesResponseMapper MAPPER_RESPONSE = new FilmesResponseMapper();
    static FilmeEntityMapper MAPPER_ENTITY = new FilmeEntityMapper();
    static ConsultarDetalhesFilmeResponseMapper MAPPER_DETALHES_FILME = new ConsultarDetalhesFilmeResponseMapper();

    public Long criarFilme(final CriarFilmeRequest request){
        FilmeEntity salvarFilme = MAPPER_ENTITY.mapear(request);
        return filmesRepository.criarFilme(salvarFilme);
    }

    public List<FilmeResponse> getFilme(final Genero genero){
        List<FilmeEntity> filmes = filmesRepository.getFilmes();
        List<FilmeEntity> filmePorGenero = filmesRepository.buscarFilmePorGenero(genero);
        if(genero != null){
            return MAPPER_RESPONSE.mapear(filmePorGenero);
        }

        return MAPPER_RESPONSE.mapear(filmes);
    }

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(final Long id){
        FilmeEntity filmeSalvo = filmesRepository.buscarFilmePorId(id);
        List<AtorEntity> atores = atoresRepository.buscarAtoresPorFilme(id);
        return MAPPER_DETALHES_FILME.mapear(filmeSalvo, atores);
    }
}
