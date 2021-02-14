import java.text.DecimalFormat;

public class Casa extends Imovel{
    private boolean patio;

    public Casa(Endereco endereco, double valor, boolean patio) {
        super(endereco, valor);
        this.patio = patio;
    }

    @Override
    public String apresentacao(){
        return "Este imóvel é uma Casa " + (this.patio ? "com pátio" : "sem pátio") + ", localizado no endereço: "
                + getEndereco().getLogradouro() + ", " + getEndereco().getNumero() + ", " + getEndereco().getBairro() +
                ", " + getEndereco().getCidade() + ", " + getEndereco().getEstado() + ". Valor " +
                DecimalFormat.getCurrencyInstance().format(getValor()) + ".";
    }
}
