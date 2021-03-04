package br.com.cwi.resetflix.response.serie;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;
import br.com.cwi.resetflix.response.ator.AtoresResponse;

public class ConsultarDetalhesSerieResponse {
    private Long id;
    private String nome;
    private Genero genero;
    private List<AtoresResponse> atores;
    private Long temporadas;
    private Long episodios;

    public ConsultarDetalhesSerieResponse(Long id, String nome, Genero genero, List<AtoresResponse> atoresResponse,
                                          Long temporadas, Long episodios)
    {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.atores = atoresResponse;
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<AtoresResponse> getAtores() {
        return atores;
    }

    public void setAtores(List<AtoresResponse> atores) {
        this.atores = atores;
    }

    public Long getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Long temporadas) {
        this.temporadas = temporadas;
    }

    public Long getEpisodios() {
        return episodios;
    }

    public void setEpisodios(Long episodios) {
        this.episodios = episodios;
    }
}
