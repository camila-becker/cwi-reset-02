package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {

    @Autowired
    FilmesRepository filmesRepository;

    @Autowired
    SeriesRepository seriesRepository;

    static List<AtorEntity> atores = new ArrayList<>();
    static Long contadorIds = 1l;

    public List<AtorEntity> getAtores(){
        return atores;
    }

    public Long criarAtor(final AtorEntity salvarAtor) {
        for(AtorEntity ator : atores){
            if(salvarAtor.getNome().equals(ator.getNome())){
                throw new BadRequestException("Ator já foi cadastrado!");
            }
        }
        if(salvarAtor.getId() == null){
            salvarAtor.setId(contadorIds);
            contadorIds++;
        }
        atores.add(salvarAtor);
        return salvarAtor.getId();
    }

    public AtorEntity buscarAtorPorId(final Long id) {
        for(AtorEntity atorEntity : atores){
            if(atorEntity.getId().equals(id)){
                return atorEntity;
            }
        }
        return null;
    }

    public List<AtorEntity> buscarAtoresPorFilme(Long id) {
        FilmeEntity filme = filmesRepository.buscarFilmePorId(id);
        List<AtorEntity> listaDeAtores = new ArrayList<>();
        for(AtorEntity ator : atores){
            if(filme.getIdsAtores().contains(ator.getId())){
                listaDeAtores.add(ator);
            }
        }

        return listaDeAtores;
    }

    public List<AtorEntity> buscarAtoresPorSerie(Long id) {
        SerieEntity serie = seriesRepository.buscarSeriePorId(id);
        List<AtorEntity> listaDeAtores = new ArrayList<>();
        for(AtorEntity ator : atores){
            if(serie.getIdsAtores().contains(ator.getId())){
                listaDeAtores.add(ator);
            }
        }
        return listaDeAtores;
    }
}
