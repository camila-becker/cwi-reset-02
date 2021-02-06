public class Main {
    public static void main(String[] args) {
        int numero1 = 6;
        int numero2 = 3;
        int multiplicacao;
        int resto;

        multiplicacao = numero1 * numero2;
        resto = numero1 % numero2;

        System.out.println(numero1 + " multiplicado por " + numero2 + " é igual a: " + multiplicacao + ".");
        System.out.println("O resto da divisão entre " + numero1 + " e " + numero2 + " é: " + resto + ".");
    }
}
