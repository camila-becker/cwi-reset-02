package exercicio01;

public class Diretor {
    private String nome;
    private int idade;
    private int quantidadeDeFilmesDirigidos;

    public Diretor(String nome, int idade, int quantidadeDeFilmesDirigidos) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
    }

    public String getNome() {
        return this.nome;
    }
}
