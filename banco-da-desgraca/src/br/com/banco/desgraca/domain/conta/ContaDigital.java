package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exception.SaldoInsuficienteException;

import java.text.DecimalFormat;

public class ContaDigital extends TiposDeConta {
    public ContaDigital(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
        validarBanco(banco);
    }

    @Override
    public String toString(){
        return "Conta Digital " + getInstituicaoBancaria().getNomeDoBanco() + " " + getNumeroDaConta();
    }

    @Override
    public void sacar(Double valor) {
        validarSaque(valor);
        if(valor >= 10){
            setSaldo(getSaldo() - valor);
            System.out.println("Sacando valor " + DecimalFormat.getCurrencyInstance().format(valor) + " da " + this.toString());
            getTransacoes().add(new Transacao(TipoTransacao.SACAR, Data.getDataTransacao(), valor, this));
        }else{
            throw new RuntimeException("O valor para saque deve ser superior ou igual a R$ 10,00");
        }
    }

    @Override
    public void transferir(Double valor, ContaBancaria contaDestino) {
        setSaldo(getSaldo() - valor);
        System.out.println("Transferindo valor " + DecimalFormat.getCurrencyInstance().format(valor) +
                " da " + this.toString() + " para a " + contaDestino.toString());
        contaDestino.depositar(valor);
        getTransacoes().add(new Transacao(TipoTransacao.TRANSFERIR, Data.getDataTransacao(), valor, this));
    }

    public void validarBanco(InstituicaoBancaria banco){
        if(banco != InstituicaoBancaria.NUBANK && banco != InstituicaoBancaria.ITAU){
            throw new RuntimeException("Não podemos criar uma conta digital para o banco " + banco.getNomeDoBanco() + "!");
        }
    }

    public void validarSaque(Double valor){
        if(valor > getSaldo()){
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
    }
}
