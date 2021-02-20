package exercicio01;

import java.util.ArrayList;
import java.util.List;

public class AplicacaoFilme {
    public static void main(String[] args) {
        List<Pessoa> elenco = new ArrayList<Pessoa>();
        Diretor diretor =  new Diretor("David Fincher", 58, 10, Genero.MASCULINO);
        elenco.add(diretor);
        elenco.add(new Ator("Brad Pitt", 57, 1, Genero.MASCULINO));
        elenco.add(new Ator("Edward Norton", 51, 0, Genero.MASCULINO));
        elenco.add(new Ator("Helena B Carter", 54, 0, Genero.FEMININO));

        Filme clubeDaLuta = new Filme("Clube da Luta",
                "Um homem comum que está descontente com o seu trabalho de classe média na sociedade americana...",
                140,
                1996,
                5,
                diretor,
                elenco
        );

        clubeDaLuta.exibirCreditos();
    }
}
