package br.com.cwi.resetflix.entity;

import br.com.cwi.resetflix.response.filme.FilmesResponse;

import java.util.List;

public class UsuarioEntity {
    private Long id;
    private String nome;
    private List<FilmesResponse> filmesAssistidos;
    private List<SerieEntity> seriesAssistidas;

    public UsuarioEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public List<FilmesResponse> getFilmesAssistidos() {
        return filmesAssistidos;
    }

    public void setFilmesAssistidos(List<FilmesResponse> filmesAssistidos) {
        this.filmesAssistidos = filmesAssistidos;
    }

    public List<SerieEntity> getSeriesAssistidas() {
        return seriesAssistidas;
    }

    public void setSeriesAssistidas(List<SerieEntity> seriesAssistidas) {
        this.seriesAssistidas = seriesAssistidas;
    }
}
