package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
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
        verificarSaldo(valor);
        validarSaque(valor);
        setSaldo(getSaldo() - valor);
        getTransacoes().add(new Transacao(TipoTransacao.SACAR, Data.getDataTransacao(), valor, this, getSaldo()));
        mensagemSaque(valor);
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        verificarSaldo(valor);
        verificarConta(contaDestino);
        setSaldo(getSaldo() - valor);
        mensagemTransferencia(valor, contaDestino);
        contaDestino.depositar(valor);
        getTransacoes().add(new Transacao(TipoTransacao.TRANSFERIR, Data.getDataTransacao(), valor, this, getSaldo()));
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
