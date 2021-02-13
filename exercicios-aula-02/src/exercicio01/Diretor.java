package exercicio01;

public class Diretor extends Pessoa{
    private int quantidadeDeFilmesDirigidos;

    public Diretor(String nome, int idade, int quantidadeDeFilmesDirigidos, Genero genero) {
        super(nome, idade, genero);
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }
}
