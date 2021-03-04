package br.com.cwi.resetflix.mapper.diretor;

import br.com.cwi.resetflix.entity.DiretorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.filme.FilmesResponseMapper;
import br.com.cwi.resetflix.response.diretor.ConsultarDetalhesDiretorResponse;
import br.com.cwi.resetflix.response.filme.FilmesResponse;

import java.util.List;

public class ConsultarDetalhesDiretorResponseMapper {

    public ConsultarDetalhesDiretorResponse mapear(final DiretorEntity diretorSalvo, final List<FilmeEntity> filmesDiretor){
        List<FilmesResponse> filmesResponse = new FilmesResponseMapper().mapear(filmesDiretor);
        return new ConsultarDetalhesDiretorResponse(diretorSalvo.getId(), diretorSalvo.getNome(), filmesResponse);
    }
}
