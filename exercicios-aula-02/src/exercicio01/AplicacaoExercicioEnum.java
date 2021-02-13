package exercicio01;

public class AplicacaoExercicioEnum {
    public static void main(String[] args) {
        Ator ator = new Ator("Brad Pitt", 57, 1, Genero.MASCULINO);
        Diretor diretor = new Diretor("Quentin Tarantino", 57, 14, Genero.MASCULINO);

        ator.apresentacao();
        diretor.apresentacao();
    }
}
