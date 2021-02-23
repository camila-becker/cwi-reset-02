package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;

import java.text.DecimalFormat;

public class ContaCorrente extends TiposDeConta {

    public ContaCorrente(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
    }

    private static final Double TAXA_DE_TRANSFERENCIA = 0.1;
    private static final Integer DIVISOR = 5;

    @Override
    public String toString(){
        return "Conta Corrente " + getInstituicaoBancaria().getNomeDoBanco() + " " + getNumeroDaConta();
    }

    private void validarSaque(Double valor){
        if(valor >= 5 && valor % DIVISOR > 0){
            throw new RuntimeException("Saque não permitido! Somente valores múltiplos e maiores que 5!");
        }
    }

    @Override
    public void sacar(Double valor) {

    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {

    }
}
