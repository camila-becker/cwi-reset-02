package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.DiretorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiretoresRepository {
    static List<DiretorEntity> diretores = new ArrayList<>();
    static Long nextId = 1l;

    public List<DiretorEntity> getDiretores(){
        return diretores;
    }

    public Long criarDiretor(final DiretorEntity salvarDiretor){
        if(salvarDiretor.getId() == null){
            salvarDiretor.setId(nextId);
            nextId++;
        }
        diretores.add(salvarDiretor);
        return salvarDiretor.getId();
    }

    public DiretorEntity buscarAtorPorId(final Long id){
        for(DiretorEntity diretorEntity : diretores){
            if(diretorEntity.getId().equals(id)){
                return diretorEntity;
            }
        }
        return null;
    }

//    public List<DiretorEntity> buscarDiretorPorFilme(Long id) {
//    }
}
