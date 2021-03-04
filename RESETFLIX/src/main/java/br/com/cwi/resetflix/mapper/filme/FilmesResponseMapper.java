package br.com.cwi.resetflix.mapper.filme;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.resetflix.entity.FilmeEntity;
import br.com.cwi.resetflix.response.filme.FilmesResponse;

public class FilmesResponseMapper {

    public List<FilmesResponse> mapear(final List<FilmeEntity> filmes) {
        List<FilmesResponse> filmesResponse = new ArrayList<>();

        for(FilmeEntity filme : filmes){
            FilmesResponse response = new FilmesResponse(filme.getId(), filme.getNome(),
                    filme.getGenero());
            filmesResponse.add(response);
        }

        return filmesResponse;
    }
}
