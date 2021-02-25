package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.domain.enuns.InstituicaoBancaria;
import br.com.banco.desgraca.exceptions.SaqueNaoPermitidoException;
import br.com.banco.desgraca.exceptions.TipoDeContaException;

public class ContaDigital extends Conta {
    public ContaDigital(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
        validarBanco(banco);
    }

    private static final Integer VALOR_MINIMO_SAQUE = 10;

    @Override
    public String toString(){
        return "Conta Digital " + getInstituicaoBancaria().getNomeDoBanco() + " " + getNumeroDaConta();
    }

    @Override
    public void sacar(Double valor) {
        validarSaque(valor);
        super.sacar(valor);
    }

    private void validarBanco(InstituicaoBancaria banco){
        if(banco != InstituicaoBancaria.NUBANK && banco != InstituicaoBancaria.ITAU){
            throw new TipoDeContaException("Não podemos criar uma conta digital para o banco " + banco.getNomeDoBanco() + "!");
        }
    }
    private void validarSaque(Double valor){
        if(valor < VALOR_MINIMO_SAQUE){
            throw new SaqueNaoPermitidoException("O valor para saque deve ser superior ou igual a R$ 10,00");
        }
    }
}
