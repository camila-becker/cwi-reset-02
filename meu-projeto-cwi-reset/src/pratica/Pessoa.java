package pratica;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String sexo;
    private int idade;
    private int peso;
    private int caminhouQuantosMetros;
    private double altura;
    private boolean andando;

    public Pessoa(String nome, String sobrenome, String sexo, int idade, int peso, double altura){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public int andar(int metrosCaminhados){
        this.andando = true;
        return this.caminhouQuantosMetros += metrosCaminhados;
    }

    public void parar(){
        this.andando = false;
    }

    public int fazerAniversario(){
        return this.idade += 1;
    }

    public void nomeCompleto(){
        System.out.println("Olá! Meu nome é " + this.nome + " " + this.sobrenome + "!");
    }

    public void mostrarIdade(){
        System.out.println("Olá! Eu tenho " + this.idade + " ano(s)!");
    }

    public void mostrarPeso(){
        System.out.println("Eu peso " + this.peso + "Kg.");
    }

    public void mostrarAltura(){
        System.out.println("Minha altura é " + this.altura + "m.");
    }

    public void apresentacao(){
        String artigo = "o";
        String pluralIdade = "anos";
        String pluralMetros = "metros";
        if(this.sexo == "Feminino"){
            artigo = "a";
        }
        if(this.idade <= 1){
            pluralIdade = "ano";
        }
        if(this.caminhouQuantosMetros <= 1){
            pluralMetros = "metro";
        }
        System.out.println("Olá eu sou " + artigo + " " + this.nome + " " + this.sobrenome + ", tenho " + this.idade + " " + pluralIdade + ", " + this.altura + "m, meu peso é " + this.peso + "kg e, só hoje, eu já caminhei " + this.caminhouQuantosMetros + " " + pluralMetros + "!");
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public int getPeso() {
        return peso;
    }

    public int getCaminhouQuantosMetros() {
        return caminhouQuantosMetros;
    }

    public double getAltura() {
        return altura;
    }

    public boolean isAndando() {
        return andando;
    }
}
