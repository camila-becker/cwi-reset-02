package pratica;

import oo.Notas;

public class AppNotas {
    public static void main(String[] args) {
        MediaDoAluno media = new MediaDoAluno();
        media.nomeDoAluno();
        media.notasDoAluno();
        System.out.println("A nota final do aluno(a) " + media.getAluno() + " é: " + media.getNotaFinal() + " e ele(a) foi: " + media.getSituacao() + ".");
    }
}
