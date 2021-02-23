package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.Transacao;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class TiposDeConta implements ContaBancaria{
    private Integer numeroDaConta;
    private InstituicaoBancaria banco;
    private Double saldo;

    private List<Transacao> transacoes = new ArrayList<Transacao>();

    public TiposDeConta(Integer numeroDaConta, InstituicaoBancaria banco) {
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
        saldo += valor;
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
}
