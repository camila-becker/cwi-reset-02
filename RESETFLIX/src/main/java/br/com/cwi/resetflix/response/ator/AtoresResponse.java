package br.com.cwi.resetflix.response.ator;

public class AtoresResponse {

    private Long id;
    private String nome;

    public AtoresResponse(final Long id, final String nome) {
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

}
