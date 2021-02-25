package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.enuns.InstituicaoBancaria;
import br.com.banco.desgraca.exceptions.SaqueNaoPermitidoException;

public class ContaCorrente extends Conta {
    public ContaCorrente(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
    }

    private static final Double TAXA_DE_TRANSFERENCIA = 0.01;
    private static final Integer DIVISOR = 5;

    @Override
    public String toString(){
        return "Conta Corrente " + getInstituicaoBancaria().getNomeDoBanco() + " " + getNumeroDaConta();
    }

    @Override
    public void sacar(Double valor) {
        validarSaque(valor);
        super.sacar(valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        verificarConta(contaDestino);
        super.transferir(valor, contaDestino);
        if(this.getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){
            setSaldo(getSaldo() - (valor * TAXA_DE_TRANSFERENCIA));
        }
    }

    private void validarSaque(Double valor){
        if(valor < 5 || valor % DIVISOR != 0){
            throw new SaqueNaoPermitidoException("Saque não permitido! Somente valores múltiplos e maiores que 5!");
        }
    }
}
