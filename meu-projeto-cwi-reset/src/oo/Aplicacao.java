package oo;

public class Aplicacao {
    public static void main(String[] args) {
        Calculadora minhaCalculadora = new Calculadora();
        System.out.println(minhaCalculadora.soma(10,10));
        System.out.println(minhaCalculadora.subtrai(10,5));
        System.out.println(minhaCalculadora.divide(10,2));
        System.out.println(minhaCalculadora.multiplica(3,3));

        Comparador comparacao = new Comparador();
        System.out.println(comparacao.menorQue(5, 10));

    }
}
