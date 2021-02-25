package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.enuns.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {

        LocalDate dataInicio = LocalDate.of(2020, 7, 1);
        LocalDate dataFim = LocalDate.of(2020, 8, 1);

        ContaDigital conta1 = new ContaDigital(123, InstituicaoBancaria.NUBANK);
        ContaCorrente conta2 = new ContaCorrente(222, InstituicaoBancaria.ITAU);
        ContaPoupanca conta3 = new ContaPoupanca(333, InstituicaoBancaria.ITAU);
        ContaCorrente conta4 = new ContaCorrente(666, InstituicaoBancaria.BRADESCO);


        System.out.println("######### Conta Digital #########");
        conta1.depositar(1000d);
        conta1.sacar(300d);
        conta1.transferir(200d, conta4);

        System.out.println("\n");

        System.out.println("######### Conta Corrente #########");
        conta2.depositar(2000d);
        conta2.sacar(300d);
        conta2.transferir(500d, conta4);

        System.out.println("\n");

        System.out.println("######### Conta Poupança #########");
        conta3.depositar(100d);
        conta3.sacar(50d);
        conta3.transferir(20d, conta4);

        System.out.println("\n");

        System.out.println("######### EXTRATOS #########");
        conta1.exibirExtrato(dataInicio, dataFim);
        System.out.println("\n");
        conta2.exibirExtrato(dataInicio, dataFim);
        System.out.println("\n");
        conta3.exibirExtrato(dataInicio, dataFim);
        System.out.println("\n");
        conta4.exibirExtrato(dataInicio, dataFim);
    }
}
