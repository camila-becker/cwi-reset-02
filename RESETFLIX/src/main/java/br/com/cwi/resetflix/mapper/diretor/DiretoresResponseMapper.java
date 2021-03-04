package br.com.cwi.resetflix.mapper.diretor;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.response.diretor.DiretoresResponse;

import java.util.ArrayList;
import java.util.List;

public class DiretoresResponseMapper {
    public List<DiretoresResponse> mapear(final List<DiretorEntity> diretores){
        List<DiretoresResponse> diretoresResponses = new ArrayList<>();
        for(DiretorEntity diretorEntity : diretores){
            DiretoresResponse diretorResponse = new DiretoresResponse(diretorEntity.getId(), diretorEntity.getNome());
            diretoresResponses.add(diretorResponse);
        }
        return diretoresResponses;
    }

    public DiretoresResponse mapearUmDiretor(final DiretorEntity diretor){
        DiretoresResponse diretorResponse = new DiretoresResponse(diretor.getId(), diretor.getNome());
        return diretorResponse;
    }
}
