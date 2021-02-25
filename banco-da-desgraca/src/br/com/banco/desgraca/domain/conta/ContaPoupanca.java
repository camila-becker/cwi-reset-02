package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exceptions.SaqueNaoPermitidoException;
import br.com.banco.desgraca.exceptions.TipoDeContaException;


public class ContaPoupanca extends Conta {
    public ContaPoupanca(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
        validarBanco(banco);
    }

    private static final Double TAXA_DE_SAQUE = 0.2;
    private static final Double TAXA_DE_TRANSFERENCIA_MESMO_BANCO = 0.05;
    private static final Double TAXA_DE_TRANSFERENCIA_OUTROS_BANCOS = 0.1;
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
        verificarSaldo(valor);
        validarSaque(valor);
        Double taxa = valor * TAXA_DE_SAQUE;
        setSaldo(getSaldo() - (valor + taxa));
        getTransacoes().add(new Transacao(TipoTransacao.SACAR, Data.getDataTransacao(), valor, this, getSaldo()));
        mensagemSaque(valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        verificarSaldo(valor);
        verificarConta(contaDestino);
        if(this.getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){
            taxa = valor * TAXA_DE_TRANSFERENCIA_OUTROS_BANCOS;
            verificarSaldo(valor);
            setSaldo(getSaldo() - (valor + taxa));
            mensagemTransferencia(valor, contaDestino);
            contaDestino.depositar(valor);
            getTransacoes().add(new Transacao(TipoTransacao.TRANSFERIR, Data.getDataTransacao(), valor, this, getSaldo()));
        }else{
            taxa = valor * TAXA_DE_TRANSFERENCIA_MESMO_BANCO;
            setSaldo(getSaldo() - (valor + taxa));
            mensagemTransferencia(valor, contaDestino);
            contaDestino.depositar(valor);
            getTransacoes().add(new Transacao(TipoTransacao.TRANSFERIR, Data.getDataTransacao(), valor, this, getSaldo()));
        }
    }

    private void validarSaque(Double valor){
        if(valor < VALOR_MINIMO_SAQUE){
            throw new SaqueNaoPermitidoException("O valor para saque deve ser superior ou igual a R$ 50,00");
        }
    }
}
