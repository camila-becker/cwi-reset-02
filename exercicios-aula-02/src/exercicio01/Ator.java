package exercicio01;

public class Ator {
    private String nome;
    private int idade;
    private int oscarsVencidos;
    private Genero genero;

    public Ator(String nome, int idade, int oscarsVencidos, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.oscarsVencidos = oscarsVencidos;
        this.genero = genero;
    }

    public void exibirAtor(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Gênero: " + this.genero.getDescricao());
    }
}
