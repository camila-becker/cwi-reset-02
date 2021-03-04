package br.com.cwi.resetflix.request;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class CriarSerieRequest {
    private String nome;
    private Long temporadas;
    private Long episodios;
    private Genero genero;
    private List<Long> idsAtores;

    public CriarSerieRequest(String nome, Long temporadas, Long episodios, Genero genero,
                             List<Long> idsAtores) {
        this.nome = nome;
        this.temporadas = temporadas;
        this.episodios = episodios;
        this.genero = genero;
        this.idsAtores = idsAtores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public void setIdsAtores(List<Long> idsAtores) {
        this.idsAtores = idsAtores;
    }
}
