package br.com.banco.desgraca;

import br.com.banco.desgraca.domain.InstituicaoBancaria;
import br.com.banco.desgraca.domain.conta.ContaDigital;

import java.time.LocalDate;

public class BancoDaDesgraca {

    public static void main(String[] args) throws Exception {
        ContaDigital conta1 = new ContaDigital(123, InstituicaoBancaria.NUBANK);
//        conta1.transferir(20D, new ContaDigital(1234, InstituicaoBancaria.ITAU));
        conta1.depositar(100D);
        conta1.sacar(50D);
        conta1.transferir(50D, new ContaDigital(12345, InstituicaoBancaria.ITAU));
        conta1.exibirExtrato(LocalDate.of(2020, 7, 1), LocalDate.of(2020, 8, 1));
    }
}
