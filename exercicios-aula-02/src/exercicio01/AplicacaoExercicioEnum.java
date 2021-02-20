package exercicio01;

import java.time.LocalDate;

public class AplicacaoExercicioEnum {
    public static void main(String[] args) {
        Ator ator = new Ator("Brad Pitt", LocalDate.of(1963, 3, 10), 1, Genero.MASCULINO);
        Diretor diretor = new Diretor("Quentin Tarantino", LocalDate.of(1963, 3, 10), 14, Genero.MASCULINO);

        ator.apresentacao();
        diretor.apresentacao();
    }
}
