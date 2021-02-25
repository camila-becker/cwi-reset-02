package br.com.banco.desgraca.exceptions;

public class TipoDeContaException extends RuntimeException {
    public TipoDeContaException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
