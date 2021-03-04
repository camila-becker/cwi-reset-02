package br.com.cwi.resetflix.mapper.serie;

import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.request.CriarSerieRequest;

public class SerieEntityMapper {
    public SerieEntity mapear(final CriarSerieRequest request){
        return new SerieEntity(request.getEpisodios(), request.getGenero(), request.getIdsAtores(),
                request.getNome(), request.getTemporadas());
    }
}
