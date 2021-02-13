package exercicio01;

public class Filme {
    private String nome;
    private String descricao;
    private int duracao;
    private int ano;
    private int avaliacao;
    private Diretor diretor;

    public Filme(String nome, String descricao, int duracao, int ano, int avaliacao, Diretor diretor){
        defineAvaliacao(avaliacao);
        validaNomeEDefineAvaliacao(nome);
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.ano = ano;
        this.diretor = diretor;
    }

    public void reproduzirFilme(){
        System.out.println("Filme: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Diretor: " + this.diretor.getNome());
        System.out.println("Avaliação: " + this.avaliacao);
    }

    private void defineAvaliacao(int avaliacao){
        if(avaliacao < 1 || avaliacao > 5){
            this.avaliacao = 3;
        }else{
            this.avaliacao = avaliacao;
        }
    }

    private void validaNomeEDefineAvaliacao(String nome){
        if("Batman vs Superman".equals(nome)){
            this.avaliacao = 1;
        }else if("O Clube da Luta".equals(nome)){
            this.avaliacao = 5;
        }
    }
}
