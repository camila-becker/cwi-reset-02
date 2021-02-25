package br.com.banco.desgraca.exceptions;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
