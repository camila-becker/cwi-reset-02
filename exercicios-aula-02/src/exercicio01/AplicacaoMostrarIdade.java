package exercicio01;

import java.time.LocalDate;

public class AplicacaoMostrarIdade {
    public static void main(String[] args) {
        Pessoa camila = new Pessoa("Camila", LocalDate.of(1991, 1, 27), Genero.FEMININO);
        camila.apresentacao();
    }
}
