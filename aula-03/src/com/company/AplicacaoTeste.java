package com.company;

import com.company.domain.Editora;
import com.company.exceptions.EditoraException;

public class AplicacaoTeste {
    public static void main(String[] args) {
        Editora editora = new Editora("DC Comics", "EUA");

        if(editora.getNome().equals("DC Comics")){
            throw new EditoraException("Nome da editora não é permitido!");
        }else{
            System.out.println(editora.getNome());
        }
    }
}
