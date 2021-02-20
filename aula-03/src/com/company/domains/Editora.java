package com.company.domains;

import com.company.exceptions.EditoraException;

public class Editora {
    private String nome;
    private String localizacao;

    public Editora(String nome, String localizacao) {
        validarNome(nome);
        this.nome = nome;
        this.localizacao = localizacao;
    }

    private void validarNome(String nome){
        if(nome.equals("DC Comics")){
            throw new EditoraException("Nome da editora não permitido!");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }
}
