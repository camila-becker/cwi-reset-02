import java.text.DecimalFormat;

public class Apartamento extends Imovel{
    private int andar;

    public Apartamento(Endereco endereco, double valor, int andar) {
        super(endereco, valor);
        this.andar = andar;
    }

    @Override
    public String apresentacao(){
        return "Este imóvel é um Apartamento localizado no " + this.andar + "° andar, no endereço: "
                + getEndereco().getLogradouro() + ". Valor " + DecimalFormat.getCurrencyInstance().format(getValor()) + ".";
    }
}
