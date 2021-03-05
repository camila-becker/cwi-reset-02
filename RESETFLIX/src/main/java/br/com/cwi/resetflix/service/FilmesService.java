package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.UsuarioEntity;
import br.com.cwi.resetflix.exception.NotFoundException;
import br.com.cwi.resetflix.mapper.filme.ConsultarDetalhesFilmeResponseMapper;
import br.com.cwi.resetflix.mapper.filme.FilmeEntityMapper;
import br.com.cwi.resetflix.mapper.filme.FilmesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.DiretoresRepository;
import br.com.cwi.resetflix.repository.FilmesRepository;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.filme.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.filme.FilmesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    public List<FilmesResponse> getFilmes(){
        final List<FilmeEntity> filmes = filmesRepository.getFilmes();
        return MAPPER_RESPONSE.mapear(filmes);
    }

    public List<FilmesResponse> getFilme(final Genero genero){
        final List<FilmeEntity> filmes = filmesRepository.buscarFilmePorGenero(genero);
        return MAPPER_RESPONSE.mapear(filmes);
    }

    public Long criarFilme(final CriarFilmeRequest request){
        FilmeEntity salvarFilme = MAPPER_ENTITY.mapear(request);
        return filmesRepository.criarFilme(salvarFilme);
    }

    public ConsultarDetalhesFilmeResponse consultarDetalhesFilme(final Long id){
        FilmeEntity filmeSalvo = filmesRepository.buscarFilmePorId(id);
        List<AtorEntity> atores = atoresRepository.buscarAtoresPorFilme(id);
        DiretorEntity diretor = diretoresRepository.buscarDiretorPorId(id);
        return MAPPER_DETALHES_FILME.mapear(filmeSalvo, diretor, atores);
    }

    public void assistirFilme(final Long id){
        UsuarioEntity usuario = new UsuarioEntity(1l, "Camila");
        FilmeEntity filme = filmesRepository.buscarFilmePorId(id);
        List<FilmeEntity> filmeAssistido = new ArrayList<>();
        filmeAssistido.add(filme);
        usuario.setFilmesAssistidos(MAPPER_RESPONSE.mapear(filmeAssistido));
    }
}
