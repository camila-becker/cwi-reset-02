package exercicio01;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private LocalDate dataDeNascimento;
    private Genero genero;

    LocalDate dataAtual = LocalDate.now();

    public Pessoa(String nome, LocalDate dataDeNascimento, Genero genero) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
    }

    public void apresentacao(){
        Period idade = Period.between(this.dataDeNascimento, dataAtual);
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + idade.getYears());
        System.out.println("Gênero: " + this.genero.getDescricao());
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public Genero getGenero() {
        return genero;
    }
}

