package exercicio01;

public class Filme {
    private String nome;
    private String descricao;
    private double duracao;
    private int ano;
    private double avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, double duracao, int ano, double avaliacao, Diretor diretor){
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ano = ano;
        this.avaliacao = avaliacao;
        this.diretor = diretor;
    }

    public void reproduzirFilme(){
        System.out.println("O nome do filme é: " + this.nome);
        System.out.println("A descrição do filme é: " + this.descricao);
        System.out.println("A duração do filme é: " + this.duracao);
        System.out.println("O diretor do filme é: " + this.diretor.nome);
    }
}
