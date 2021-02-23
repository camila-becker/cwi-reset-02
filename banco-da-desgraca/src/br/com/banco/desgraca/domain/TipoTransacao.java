package br.com.banco.desgraca.domain;

public enum TipoTransacao {
    DEPOSITAR ("Depósito"),
    SACAR ("Saque"),
    TRANSFERIR("Transferência"),
    EXTRATO ("Extrato"),
    ;

    private String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
