package br.com.cwi.resetflix.mapper.filme;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.ator.AtoresResponseMapper;
import br.com.cwi.resetflix.mapper.diretor.DiretoresResponseMapper;
import br.com.cwi.resetflix.response.ator.AtoresResponse;
import br.com.cwi.resetflix.response.filme.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.diretor.DiretoresResponse;

import java.util.List;

public class ConsultarDetalhesFilmeResponseMapper {
    public ConsultarDetalhesFilmeResponse mapear(final FilmeEntity filme,
                                                 final DiretorEntity diretor, final List<AtorEntity> atores){
        List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atores);
        DiretoresResponse diretorResponse = new DiretoresResponseMapper().mapearUmDiretor(diretor);
        return new ConsultarDetalhesFilmeResponse(filme.getId(), filme.getNome(),filme.getGenero(), diretorResponse,
                atoresResponse);
    }
}
