package pratica;

import java.util.Scanner;

public class MediaDoAluno {
    private String aluno;
    private double notaFinal;
    private String situacao;

    Scanner teclado = new Scanner(System.in);

    public String nomeDoAluno(){
        System.out.println("Informe o nome do aluno: ");
        return this.aluno = teclado.nextLine();
    }

    public void notasDoAluno(){
        int nota1 = 0;
        int nota2 = 0;
        int nota3 = 0;
        int nota4 = 0;

        System.out.println("Informe a primeira nota do aluno: ");
        nota1 += teclado.nextInt();
        System.out.println("Informe a segunda nota do aluno: ");
        nota2 += teclado.nextInt();
        System.out.println("Informe a terceira nota do aluno: ");
        nota3 += teclado.nextInt();
        System.out.println("Informe a quarta nota do aluno: ");
        nota4 += teclado.nextInt();
        this.notaFinal = (nota1 + nota2 + nota3 + nota4) / 4;
        if(this.notaFinal >= 7.0){
            this.situacao = "Aprovado";
        }else {
            this.situacao = "Reprovado";
        }
    }

    public String getAluno() {
        return aluno;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public String getSituacao() {
        return situacao;
    }
}
