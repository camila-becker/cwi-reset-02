package exercicio01;

import java.time.LocalDate;

public class Ator extends Pessoa{
    private int oscarsVencidos;

    public Ator(String nome, LocalDate idade, int oscarsVencidos, Genero genero) {
        super(nome, idade, genero);
        this.oscarsVencidos = oscarsVencidos;
    }

    @Override
    public void apresentacao(){
        super.apresentacao();
        System.out.println("Quantidade de Oscars Vencidos: " + this.oscarsVencidos);
    }
}
