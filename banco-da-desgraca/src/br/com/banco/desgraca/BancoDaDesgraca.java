package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaCorrente;
import br.com.banco.desgraca.domain.conta.ContaDigital;
import br.com.banco.desgraca.domain.conta.ContaPoupanca;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {
        ContaDigital conta1 = new ContaDigital(123, InstituicaoBancaria.NUBANK);
        ContaCorrente conta2 = new ContaCorrente(222, InstituicaoBancaria.BANCO_DO_BRASIL);
        ContaPoupanca conta3 = new ContaPoupanca(333, InstituicaoBancaria.ITAU);

        System.out.println("######### CONTA DIGITAL #########");
        conta1.depositar(1000d);
        conta1.transferir(200d, conta3);
        conta1.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2020, 8, 1));

        System.out.println("######### CONTA CORRENTE #########");
        conta2.depositar(2000d);
        conta2.sacar(300d);
        conta2.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2020, 8, 1));

        System.out.println("######### CONTA POUPANÇA #########");
        conta3.depositar(100d);
        conta3.sacar(50d);
        conta3.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2020, 8, 1));


    }
}
