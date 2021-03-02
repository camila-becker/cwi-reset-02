package br.com.cwi.resetflix.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.resetflix.entity.AtorEntity;

@Repository
public class AtoresRepository {

    static List<AtorEntity> atores = new ArrayList<>();
    static Long contadorIds = 1l;

    public List<AtorEntity> getAtores(){
        return atores;
    }

    public Long criarAtor(final AtorEntity salvarAtor) {
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
        List<AtorEntity> atorSalvo = new ArrayList<>();
        for(AtorEntity ator : atores){
            if(ator.getId().equals(id)){
                atorSalvo.add(ator);
            }
        }
        return atorSalvo;
    }
}
