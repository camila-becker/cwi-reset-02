package com.company;

import com.company.domains.Editora;

public class AplicacaoTeste {
    public static void main(String[] args) {
        Editora editora = new Editora("DC Comics", "EUA");
        System.out.println(editora.getNome());
    }
}
