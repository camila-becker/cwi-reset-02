package br.com.banco.desgraca.domain.conta;

import br.com.banco.desgraca.Data;
import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.TipoTransacao;
import br.com.banco.desgraca.domain.Transacao;
import br.com.banco.desgraca.exceptions.SaqueNaoPermitidoException;

public class ContaCorrente extends Conta {

    public ContaCorrente(Integer numeroDaConta, InstituicaoBancaria banco) {
        super(numeroDaConta, banco);
    }

    private static final Double TAXA_DE_TRANSFERENCIA = 0.1;
    private static final Integer DIVISOR = 5;

    @Override
    public String toString(){
        return "Conta Corrente " + getInstituicaoBancaria().getNomeDoBanco() + " " + getNumeroDaConta();
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
        if(this.getInstituicaoBancaria() != contaDestino.getInstituicaoBancaria()){
            Double taxa = valor * TAXA_DE_TRANSFERENCIA;
            verificarSaldo(valor);
            setSaldo(getSaldo() - (valor + taxa));
            mensagemTransferencia(valor, contaDestino);
            contaDestino.depositar(valor);
            getTransacoes().add(new Transacao(TipoTransacao.TRANSFERIR, Data.getDataTransacao(), valor, this, getSaldo()));
        }else{
            setSaldo(getSaldo() - valor);
            mensagemTransferencia(valor, contaDestino);
            contaDestino.depositar(valor);
            getTransacoes().add(new Transacao(TipoTransacao.TRANSFERIR, Data.getDataTransacao(), valor, this, getSaldo()));
        }
    }

    private void validarSaque(Double valor){
        if(valor < 5 || valor % DIVISOR != 0){
            throw new SaqueNaoPermitidoException("Saque não permitido! Somente valores múltiplos e maiores que 5!");
        }
    }
}
