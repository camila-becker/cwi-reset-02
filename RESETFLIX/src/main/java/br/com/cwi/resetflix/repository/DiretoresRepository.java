package br.com.cwi.resetflix.repository;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.exception.BadRequestException;
import br.com.cwi.resetflix.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DiretoresRepository {

    @Autowired
    FilmesRepository filmesRepository;

    static List<DiretorEntity> diretores = new ArrayList<>();
    static Long nextId = 1l;

    public List<DiretorEntity> getDiretores(){
        return diretores;
    }

    public Long criarDiretor(final DiretorEntity salvarDiretor){
        for(DiretorEntity diretor : diretores){
            if(diretor.getNome().equals(salvarDiretor.getNome())){
                throw new BadRequestException("Diretor já cadastrado!");
            }
        }
        if(salvarDiretor.getId() == null){
            salvarDiretor.setId(nextId);
            nextId++;
        }
        diretores.add(salvarDiretor);
        return salvarDiretor.getId();
    }

    public DiretorEntity buscarDiretorPorId(final Long id){
        for(DiretorEntity diretorEntity : diretores){
            if(diretorEntity.getId().equals(id)){
                return diretorEntity;
            }
        }
        throw new NotFoundException("Diretor não encontrado!");
    }
}
