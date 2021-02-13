package exercicio01;

public class Aplicacao {
    public static void main(String[] args) {
        Diretor quentinTarantino = new Diretor("Quentin Tarantino", 57, 14, Genero.MASCULINO);
        Filme djangoLivre = new Filme("Django Livre",
                "Situado na era antes da guerra do Deep South e Velho Oeste, " +
                        "o filme acompanha um escravo liberto, que caminha por todo os Estados Unidos com um caçador de " +
                        "recompensas em uma missão para resgatar sua esposa de um fazendeiro cruel.",
                147,
                2012,
                4.7,
                quentinTarantino
        );

        Diretor christopherNolan = new Diretor("Christopher Nolan", 50, 10, Genero.MASCULINO);
        Filme interstellar = new Filme("Interstellar", "Conta a história de uma equipe de astronautas que " +
                "viaja através de um buraco de minhoca à procura de um novo lar para a humanidade.",
                149,
                2014,
                3.8,
                christopherNolan
        );

        djangoLivre.reproduzirFilme();
        System.out.println("######################################");
        interstellar.reproduzirFilme();

    }
}
