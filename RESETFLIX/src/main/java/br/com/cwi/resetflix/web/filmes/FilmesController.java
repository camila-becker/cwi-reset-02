package br.com.cwi.resetflix.web.filmes;

import java.util.Collections;
import java.util.List;

import br.com.cwi.resetflix.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.request.CriarFilmeRequest;
import br.com.cwi.resetflix.response.filme.ConsultarDetalhesFilmeResponse;
import br.com.cwi.resetflix.response.filme.FilmesResponse;

@RestController
@RequestMapping("/filmes")
public class FilmesController implements FilmesContract {

    @Autowired
    FilmesService filmesService;


    @Override
    @GetMapping
    public List<FilmesResponse> getFilmes(@RequestParam(value = "genero", required = false) final Genero genero) {
        return filmesService.getFilme(genero);
    }

    @Override
    @GetMapping("/{id}")
    public ConsultarDetalhesFilmeResponse getFilmeById(@PathVariable("id") final Long id) {
        return filmesService.consultarDetalhesFilme(id);
    }

    @Override
    @PostMapping
    public Long criarFilme(@RequestBody final CriarFilmeRequest request) {
        return filmesService.criarFilme(request);
    }

    @Override
    @GetMapping("/recomendacoes")
    public List<FilmesResponse> getRecomendacoesFilmes() {
        return filmesService.getFilmes();
    }

    @Override
    @PostMapping("/{id}/assistir")
    public void assistirFilme(@PathVariable("id") final Long id) {
        //TODO realizar chamada
    }
}
