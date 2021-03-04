package br.com.cwi.resetflix.mapper.ator;

import java.util.List;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.mapper.filme.FilmesResponseMapper;
import br.com.cwi.resetflix.response.ator.ConsultarDetalhesAtorResponse;
import br.com.cwi.resetflix.response.filme.FilmesResponse;

public class ConsultarDetalhesAtorResponseMapper {

    public ConsultarDetalhesAtorResponse mapear(final AtorEntity atorSalvo, final List<FilmeEntity> filmesAtor) {
        List<FilmesResponse> filmesResponse = new FilmesResponseMapper().mapear(filmesAtor);
        return new ConsultarDetalhesAtorResponse(atorSalvo.getId(),
            atorSalvo.getNome(), filmesResponse);
    }
}
