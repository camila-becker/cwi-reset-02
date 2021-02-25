package br.com.banco.desgraca.domain.enuns;

public enum InstituicaoBancaria {

    BANCO_DO_BRASIL("Banco do Brasil"),
    BRADESCO (" Banco Bradesco"),
    CAIXA ("Caixa Econômica Federal"),
    ITAU ("Banco Itaú"),
    NUBANK ("Banco Nubank");

    private String nomeDoBanco;

    InstituicaoBancaria(String nomeDoBanco){
        this.nomeDoBanco = nomeDoBanco;
    }

    public String getNomeDoBanco(){
        return nomeDoBanco;
    }
}
