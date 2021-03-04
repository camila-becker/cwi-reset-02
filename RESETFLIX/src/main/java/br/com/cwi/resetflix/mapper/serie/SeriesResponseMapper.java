package br.com.cwi.resetflix.mapper.serie;

import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.response.serie.SeriesResponse;

import java.util.ArrayList;
import java.util.List;

public class SeriesResponseMapper {
    public List<SeriesResponse> mapear(final List<SerieEntity> series){
        List<SeriesResponse> seriesResponse = new ArrayList<>();
        for(SerieEntity serie : series){
            SeriesResponse response = new SeriesResponse(serie.getId(), serie.getNome(), serie.getGenero());
            seriesResponse.add(response);
        }

        return seriesResponse;
    }
}
