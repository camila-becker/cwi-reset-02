package pratica;

public class App {
    public static void main(String[] args) {
        Pessoa novaPessoa = new Pessoa("Camila", "Becker", "Feminino", 29, 90, 1.65);
        System.out.println("Qual o nome completo da pessoa?");
        novaPessoa.nomeCompleto();

        System.out.println("Qual a idade da pessoa?");
        novaPessoa.mostrarIdade();

        System.out.println("Qual o peso da pessoa?");
        novaPessoa.mostrarPeso();

        System.out.println("Qual a altura da pessoa?");
        novaPessoa.mostrarAltura();

        System.out.println("A pessoa está fazendo aniversário! Qual a idade da pessoa agora?");
        novaPessoa.fazerAniversario();
        novaPessoa.mostrarIdade();

        System.out.println("A pessoa precisa caminhar alguns metros! Quantos metros a pessoa caminhou?");
        novaPessoa.andar(350);
        System.out.println(novaPessoa.getCaminhouQuantosMetros());

        System.out.println("A pessoa ainda está andando? ");
        System.out.println(novaPessoa.isAndando());

        System.out.println("Faça a pessoa parar. Ela ainda está andando?");
        novaPessoa.parar();
        System.out.println(novaPessoa.isAndando());

        System.out.println("Agora faça uma apresentação completa da pessoa!");
        novaPessoa.apresentacao();

    }
}
