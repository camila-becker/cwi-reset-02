package exercicio01;

import java.time.LocalDate;

public class Diretor extends Pessoa{
    private int quantidadeDeFilmesDirigidos;

    public Diretor(String nome, LocalDate idade, int quantidadeDeFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    @Override
    public void apresentacao(){
        super.apresentacao();
        System.out.println("Quantidade de Filmes Dirigidos: " + this.quantidadeDeFilmesDirigidos);
    }
}
