package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.enuns.InstituicaoBancaria;
import br.com.banco.desgraca.domain.enuns.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exceptions.SaldoInsuficienteException;
import br.com.banco.desgraca.exceptions.TransferenciaParaMesmaContaException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements ContaBancaria{
    private Integer numeroDaConta;
    private InstituicaoBancaria banco;
    private Double saldo;

    private List<Transacao> transacoes = new ArrayList<Transacao>();

    public Conta(Integer numeroDaConta, InstituicaoBancaria banco) {
        this.numeroDaConta = numeroDaConta;
        this.banco = banco;
        this.saldo = 0d;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    @Override
    public String toString(){
        return banco.getNomeDoBanco() + " " + getNumeroDaConta();
    }

    @Override
    public InstituicaoBancaria getInstituicaoBancaria() {
        return banco;
    }

    @Override
    public Double consultarSaldo() {
        return getSaldo();
    }

    @Override
    public void depositar(Double valor) {
        setSaldo(valor);
        getTransacoes().add(new Transacao(TipoTransacao.DEPOSITAR, Data.getDataTransacao(), valor, this, this.saldo));
        System.out.println("Depositando " + DecimalFormat.getCurrencyInstance().format(valor) + " na " + this.toString());
    }

    @Override
    public void sacar(Double valor){
        verificarSaldo(valor);
        setSaldo(getSaldo() - valor);
        transacoes.add(new Transacao(TipoTransacao.SACAR, Data.getDataTransacao(), valor, this, this.saldo));
        mensagemSaque(valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino){
        verificarSaldo(valor);
        setSaldo(getSaldo() - valor);
        mensagemTransferencia(valor, contaDestino);
        contaDestino.depositar(valor);
        transacoes.add(new Transacao(TipoTransacao.TRANSFERIR, Data.getDataTransacao(), valor, this, this.saldo));
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        System.out.println("******** Extrato " + this.toString() + " ********" + "\n");
        for(Transacao transacao : transacoes){
            System.out.println(transacao + "\n");
        }
    }

    public void verificarSaldo(Double valor){
        if(valor > getSaldo()){
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
    }

    public void verificarConta(ContaBancaria contaDestino){
        if(contaDestino.equals(this)){
            throw new TransferenciaParaMesmaContaException("Não é possível realizar transferências para a mesma conta!");
        }
    }

    public void mensagemSaque(Double valor){
        System.out.println("Sacando valor " + DecimalFormat.getCurrencyInstance().format(valor) + " da " +
                this.toString());
    }

    public void mensagemTransferencia(Double valor, ContaBancaria contaDestino){
        System.out.println("Transferindo valor " + DecimalFormat.getCurrencyInstance().format(valor) +
                " da " + this.toString() + " para a " + contaDestino.toString());
    }
}
