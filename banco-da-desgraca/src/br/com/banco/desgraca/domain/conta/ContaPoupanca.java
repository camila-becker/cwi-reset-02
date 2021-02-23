package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;

public class ContaPoupanca extends TiposDeConta {
    public ContaPoupanca(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
        validarBanco(banco);
    }

    @Override
    public String toString(){
        return "Conta Poupança " + getInstituicaoBancaria().getNomeDoBanco() + " " + getNumeroDaConta();
    }

    public void validarBanco(InstituicaoBancaria banco){
        if(banco.equals(InstituicaoBancaria.NUBANK)){
            throw new RuntimeException("Não podemos criar uma conta poupança para o banco " + banco.getNomeDoBanco() + "!");
        }
    }

    @Override
    public void sacar(Double valor) {

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

    }
}
