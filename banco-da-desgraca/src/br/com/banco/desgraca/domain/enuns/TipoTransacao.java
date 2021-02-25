package br.com.banco.desgraca.domain.enuns;

public enum TipoTransacao {
    DEPOSITAR ("Depósito"),
    SACAR ("Saque"),
    TRANSFERIR("Transferência");

    private String descricao;

    TipoTransacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
