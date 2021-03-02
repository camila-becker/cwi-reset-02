package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import br.com.cwi.resetflix.entity.FilmeEntity;

@Repository
public class FilmesRepository {

    @Autowired
    AtoresRepository atoresRepository;

    @Autowired
    DiretoresRepository diretoresRepository;

    static List<FilmeEntity> filmes = new ArrayList<>();
    static Long nextId = 1l;

    public List<FilmeEntity> getFilmes(){
        return filmes;
    }

    public Long criarFilme(final FilmeEntity salvarFilme){
        if(salvarFilme.getId() == null){
            salvarFilme.setId(nextId);
            nextId++;
        }
        filmes.add(salvarFilme);
        return salvarFilme.getId();
    }

    public List<FilmeEntity> acharFilmesAtor(final Long id) {
        AtorEntity ator = atoresRepository.buscarAtorPorId(id);
        List<FilmeEntity> listaDeFilmes = new ArrayList<>();
        for(FilmeEntity filme : filmes){
            if(ator.getIdsFilmes().contains(filme.getId())){
                listaDeFilmes.add(filme);
            }
        }
        return listaDeFilmes;
    }

    public List<FilmeEntity> acharFilmesDiretor(final Long id) {
        DiretorEntity diretor = diretoresRepository.buscarAtorPorId(id);
        List<FilmeEntity> listaDeFilmes = new ArrayList<>();
        for(FilmeEntity filme : filmes){
            if(diretor.getIdsFilmes().contains(filme.getId())){
                listaDeFilmes.add(filme);
            }
        }
        return listaDeFilmes;
    }

    public List<FilmeEntity> buscarFilmePorGenero(final Genero genero){
        List<FilmeEntity> filmeSalvo = new ArrayList<>();
        for(FilmeEntity filme : filmes){
            if(filme.getGenero().equals(genero)){
                filmeSalvo.add(filme);
            }
        }
        return filmeSalvo;
    }

    public FilmeEntity buscarFilmePorId(Long id) {
        for(FilmeEntity filmeEntity : filmes){
            if(filmeEntity.getId().equals(id)){
                return filmeEntity;
            }
        }
        return null;
    }
}
