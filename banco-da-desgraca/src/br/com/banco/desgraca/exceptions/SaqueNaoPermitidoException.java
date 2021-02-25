package br.com.banco.desgraca.exceptions;

public class SaqueNaoPermitidoException extends RuntimeException{
    public SaqueNaoPermitidoException(String mensagemDeErro) {
        super(mensagemDeErro);
    }
}
