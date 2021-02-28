package br.com.cwi.resetflix.mapper;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.AtoresResponse;
import br.com.cwi.resetflix.response.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.DiretoresResponse;

import java.util.List;

public class ConsultarDetalhesFilmeResponseMapper {
    public ConsultarDetalhesFilmeResponse mapear(final FilmeEntity filme, final List<AtorEntity> atores){
        List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atores);
//        List<DiretoresResponse> diretoresResponse = new DiretoresResponseMapper().mapear(diretores);
        return new ConsultarDetalhesFilmeResponse(filme.getId(), filme.getNome(),filme.getGenero(),
                atoresResponse);
    }
}
