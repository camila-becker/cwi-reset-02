package oo;

public class Notas {
    private String aluno;
    private double notaFinal;
    private String situacao;

    public Notas(String aluno){
        this.aluno = aluno;
    }

    public void notasDoAluno(double nota1, double nota2, double nota3, double nota4){
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
