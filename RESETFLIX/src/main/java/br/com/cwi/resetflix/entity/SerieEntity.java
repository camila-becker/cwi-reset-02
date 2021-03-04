package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.domain.Genero;

import java.util.List;

public class SerieEntity {
    private Long id;
    private String nome;
    private Genero genero;
    private List<Long> idsAtores;
    private Long temporadas;
    private Long episodios;

    public SerieEntity(Long episodios, Genero genero, List<Long> idsAtores, String nome,
                       Long temporadas) {
        this.nome = nome;
        this.genero = genero;
        this.idsAtores = idsAtores;
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

    public List<Long> getIdsAtores() {
        return idsAtores;
    }

    public void setIdsAtores(List<Long> idsAtores) {
        this.idsAtores = idsAtores;
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
