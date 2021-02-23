package br.com.banco.desgraca.domain;

import br.com.banco.desgraca.domain.conta.TiposDeConta;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {
    private TipoTransacao tipo;
    private LocalDate data;
    private Double valor;
    private TiposDeConta conta;

    public Transacao(TipoTransacao tipo, LocalDate data, Double valor, TiposDeConta conta) {
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.conta = conta;
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
        return "Conta " + conta.getNumeroDaConta() + " - Banco " + conta.getInstituicaoBancaria().getNomeDoBanco()
                + "\n" + "** " + tipo.getDescricao() + " em: " + data.format(dataFormatada) + "\n" +
                "Valor " + DecimalFormat.getCurrencyInstance().format(valor);
    }
}