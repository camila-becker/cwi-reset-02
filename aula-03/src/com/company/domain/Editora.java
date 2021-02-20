package com.company.domain;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
