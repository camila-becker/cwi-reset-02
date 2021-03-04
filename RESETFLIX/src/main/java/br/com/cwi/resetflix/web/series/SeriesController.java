package br.com.cwi.resetflix.web.series;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarSerieRequest;
import br.com.cwi.resetflix.response.serie.ConsultarDetalhesSerieResponse;
import br.com.cwi.resetflix.response.serie.SeriesResponse;
import br.com.cwi.resetflix.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController implements SeriesContract{
    @Autowired
    SeriesService seriesService;

    @Override
    @GetMapping
    public List<SeriesResponse> getSeries(@RequestParam(value = "genero", required = false) final Genero genero) {
        return seriesService.getSeriePorGenero(genero);
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesSerieResponse getSerieById(@PathVariable("id") final Long id) {
        return seriesService.consultarDetalhesSerie(id);
    }

    @Override
    @PostMapping
    public Long criarSerie(@RequestBody final CriarSerieRequest request) {
        return seriesService.criarSerie(request);
    }

    @Override
    public List<SeriesResponse> getSeries() {
        return null;
    }

    @Override
    public void assistirSerie(Long id, Integer temporada, Integer episodio) {

    }
}
