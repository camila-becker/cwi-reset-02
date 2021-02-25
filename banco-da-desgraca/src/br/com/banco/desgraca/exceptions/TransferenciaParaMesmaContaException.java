package br.com.banco.desgraca.exceptions;

public class TransferenciaParaMesmaContaException extends RuntimeException {
    public TransferenciaParaMesmaContaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
