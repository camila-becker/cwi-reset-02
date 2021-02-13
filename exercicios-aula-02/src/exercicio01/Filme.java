package exercicio01;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int ano;
    private double avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracao, int ano, double avaliacao, Diretor diretor){
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ano = ano;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzirFilme(){
        System.out.println("Filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Diretor: " + this.diretor.getNome());
    }
}
