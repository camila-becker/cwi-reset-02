package br.com.cwi.resetflix.service;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.entity.AtorEntity;
import br.com.cwi.resetflix.entity.SerieEntity;
import br.com.cwi.resetflix.mapper.serie.ConsultarDetalhesSerieResponseMapper;
import br.com.cwi.resetflix.mapper.serie.SerieEntityMapper;
import br.com.cwi.resetflix.mapper.serie.SeriesResponseMapper;
import br.com.cwi.resetflix.repository.AtoresRepository;
import br.com.cwi.resetflix.repository.SeriesRepository;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.serie.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.serie.SeriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private AtoresRepository atoresRepository;

    static SeriesResponseMapper MAPPER_RESPONSE = new SeriesResponseMapper();
    static SerieEntityMapper MAPPER_ENTITY = new SerieEntityMapper();
    static ConsultarDetalhesSerieResponseMapper MAPPER_DETALHES_SERIE = new ConsultarDetalhesSerieResponseMapper();

    public List<SeriesResponse> getSeries(){
        final List<SerieEntity> series = seriesRepository.getSeries();
        return MAPPER_RESPONSE.mapear(series);
    }

    public List<SeriesResponse> getSeriePorGenero(final Genero genero){
        final List<SerieEntity> series = seriesRepository.buscarSeriePorGenero(genero);
        return MAPPER_RESPONSE.mapear(series);
    }

    public Long criarSerie(final CriarSerieRequest request){
        SerieEntity salvarSerie = MAPPER_ENTITY.mapear(request);
        return seriesRepository.criarSerie(salvarSerie);
    }

    public ConsultarDetalhesSerieResponse consultarDetalhesSerie(final Long id){
        SerieEntity series = seriesRepository.buscarSeriePorId(id);
        List<AtorEntity> atores = atoresRepository.buscarAtoresPorSerie(id);
        return MAPPER_DETALHES_SERIE.mapear(series, atores);
    }
}
