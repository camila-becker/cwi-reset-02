package br.com.cwi.resetflix.mapper.serie;

import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.mapper.ator.AtoresResponseMapper;
import br.com.cwi.resetflix.response.ator.AtoresResponse;
import br.com.cwi.resetflix.response.serie.ConsultarDetalhesSerieResponse;

import java.util.List;

public class ConsultarDetalhesSerieResponseMapper {
    public ConsultarDetalhesSerieResponse mapear(final SerieEntity serie, final List<AtorEntity> atores){
        List<AtoresResponse> atoresResponse = new AtoresResponseMapper().mapear(atores);
        return new ConsultarDetalhesSerieResponse(serie.getId(), serie.getNome(), serie.getGenero(), atoresResponse,
                serie.getTemporadas(),serie.getEpisodios());
    }
}
