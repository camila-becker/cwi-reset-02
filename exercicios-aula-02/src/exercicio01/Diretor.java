package exercicio01;

public class Diretor {
    private String nome;
    private int idade;
    private int quantidadeDeFilmesDirigidos;
    private Genero genero;

    public Diretor(String nome, int idade, int quantidadeDeFilmesDirigidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeDeFilmesDirigidos = quantidadeDeFilmesDirigidos;
        this.genero = genero;
    }

    public void exibirDiretor(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Gênero: " + this.genero.getDescricao());
    }

    public String getNome() {
        return this.nome;
    }
}
