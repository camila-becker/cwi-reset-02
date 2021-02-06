package oo;

public class Calculadora {
    public int soma(int numero1, int numero2){
        System.out.println("A soma entre " + numero1 + " e " + numero2 + " é:");
        return numero1 + numero2;
    }

    public int subtrai(int numero1, int numero2){
        System.out.println("A subtração entre " + numero1 + " e " + numero2 + " é:");
        return numero1 - numero2;
    }

    public int divide(int numero1, int numero2){
        System.out.println("A divisão entre " + numero1 + " e " + numero2 + " é:");
        return numero1 / numero2;
    }

    public int multiplica(int numero1, int numero2){
        System.out.println("A multiplicação entre " + numero1 + " e " + numero2 + " é:");
        return numero1 * numero2;
    }
}
