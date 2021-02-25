package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.Conta;
import br.com.banco.desgraca.domain.enuns.TipoTransacao;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private TipoTransacao tipo;
    private LocalDate data;
    private Double valor;
    private Conta conta;
    private Double saldo;

    public Transacao(TipoTransacao tipo, LocalDate data, Double valor, Conta conta, Double saldo) {
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.conta = conta;
        this.saldo = saldo;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public String toString(){
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Conta " + conta.getNumeroDaConta() + " - " + conta.getInstituicaoBancaria().getNomeDoBanco()
                + "\n" + "** " + tipo.getDescricao() + " em: " + data.format(dataFormatada) + "\n" +
                "Valor " + DecimalFormat.getCurrencyInstance().format(valor) + "\n" + "Saldo atual " +
                DecimalFormat.getCurrencyInstance().format(this.saldo);
    }
}