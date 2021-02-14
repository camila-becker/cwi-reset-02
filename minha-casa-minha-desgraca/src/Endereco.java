public class Endereco {
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(String logradouro, int numero, String complemento, String bairro, String cidade,
                    String estado)
    {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getEstado() {
        return estado;
    }
}
