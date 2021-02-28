package br.com.cwi.resetflix.response;

import java.util.List;

import br.com.cwi.resetflix.domain.Genero;

public class ConsultarDetalhesFilmeResponse {

    private Long id;
    private String nome;
    private Genero genero;
    private List<DiretoresResponse> diretor;
    private List<AtoresResponse> atores;

    public ConsultarDetalhesFilmeResponse(Long id, String nome, Genero genero, List<AtoresResponse> atoresResponse) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
//        this.diretor = diretoresResponse;
        this.atores = atoresResponse;
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

    public List<DiretoresResponse> getDiretor() {
        return diretor;
    }

    public void setDiretor(List<DiretoresResponse> diretor) {
        this.diretor = diretor;
    }

    public List<AtoresResponse> getAtores() {
        return atores;
    }

    public void setAtores(List<AtoresResponse> atores) {
        this.atores = atores;
    }
}
