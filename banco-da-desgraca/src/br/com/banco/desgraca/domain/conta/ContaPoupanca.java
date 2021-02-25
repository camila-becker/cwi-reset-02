package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.enuns.InstituicaoBancaria;
import br.com.banco.desgraca.exceptions.SaqueNaoPermitidoException;
import br.com.banco.desgraca.exceptions.TipoDeContaException;


public class ContaPoupanca extends Conta {
    public ContaPoupanca(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
        validarBanco(banco);
    }

    private static final Double TAXA_DE_SAQUE = 0.02;
    private static final Double TAXA_DE_TRANSFERENCIA_MESMO_BANCO = 0.005;
    private static final Double TAXA_DE_TRANSFERENCIA_OUTROS_BANCOS = 0.01;
    private static final Integer VALOR_MINIMO_SAQUE = 50;
    private Double taxa = 0d;

    @Override
    public String toString(){
        return "Conta Poupança " + getInstituicaoBancaria().getNomeDoBanco() + " " + getNumeroDaConta();
    }

    private void validarBanco(InstituicaoBancaria banco){
        if(banco.equals(InstituicaoBancaria.NUBANK)){
            throw new TipoDeContaException("Não podemos criar uma conta poupança para o banco " + banco.getNomeDoBanco() + "!");
        }
    }

    @Override
    public void sacar(Double valor) {
        validarSaque(valor);
        super.sacar(valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        verificarConta(contaDestino);
        if(this.getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){
            setSaldo(getSaldo() - (valor * TAXA_DE_TRANSFERENCIA_OUTROS_BANCOS));
            super.transferir(valor, contaDestino);
        }else{
            setSaldo(getSaldo() - (valor * TAXA_DE_TRANSFERENCIA_MESMO_BANCO));
            super.transferir(valor, contaDestino);
        }

    }

    private void validarSaque(Double valor){
        if(valor < VALOR_MINIMO_SAQUE){
            throw new SaqueNaoPermitidoException("O valor para saque deve ser superior ou igual a R$ 50,00");
        }else{
            setSaldo(getSaldo() - (valor * TAXA_DE_SAQUE));
        }
    }
}
