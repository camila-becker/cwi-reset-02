package br.com.cwi.resetflix.domain;

public enum Genero {
    SUSPENSE ("Suspense"),
    ACAO ("Ação"),
    ROMANCE("Romance"),
    COMEDIA_ROMANTICA("Comédia Romântica"),
    TERROR("Terror"),
    TEEN("Teen"),
    ;

    private String nome;

    Genero(String nome) {
        this.nome = nome;
    }
}
