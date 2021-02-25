package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
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

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
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
        getTransacoes().add(new Transacao(TipoTransacao.DEPOSITAR, Data.getDataTransacao(), valor, this, getSaldo()));
        System.out.println("Depositando " + DecimalFormat.getCurrencyInstance().format(valor) + " na " + this.toString());
    }

    @Override
    public void exibirExtrato(LocalDate inicio, LocalDate fim) {
        for(Transacao transacao : transacoes){
            if(transacao.getData().compareTo(inicio) >= 0 && transacao.getData().compareTo(fim) <= 0){
                System.out.println("---------------------------------------------------");
                System.out.println(transacao.toString());
            }
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
