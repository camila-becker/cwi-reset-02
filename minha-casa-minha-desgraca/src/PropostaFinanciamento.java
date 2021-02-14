public class PropostaFinanciamento {
    private Beneficiario beneficiario;
    private Imovel imovel;
    private int mesesParaPagamento;

    double percentualValorImovel;

    public PropostaFinanciamento(Beneficiario beneficiario, Imovel imovelEscolhido, int mesesParaPagamento) {
        this.beneficiario = beneficiario;
        this.imovel = imovelEscolhido;
        this.mesesParaPagamento = mesesParaPagamento;
    }

    /**
     * Valida a proposta de financiamento e apresenta o resultado para o cliente.
     *
     * A proposta de financiamento é aceita somente se o salário do beneficiário multiplicado pelo prazo de pagamento
     *   for equivalente a pelo menos 50% do valor do imóvel.
     *
     *   Esta regra possui duas exceções: se o imóvel se localiza no estado SP ou RJ,
     *      o salário multiplicado pelo prazo deve ser equivalente a 65% e 60% do valor imóvel (respectivamente).
     */
    public void validarProposta() {


        if(this.imovel.getEndereco().getEstado().equals("São Paulo")){
            this.percentualValorImovel = this.imovel.getValor() * 0.65;
        }else if(this.imovel.getEndereco().getEstado().equals("Rio de Janeiro")){
            this.percentualValorImovel = this.imovel.getValor() * 0.6;
        }else{
            this.percentualValorImovel = this.imovel.getValor() * 0.5;
        }

        if((this.beneficiario.getSalario() * this.mesesParaPagamento) >= this.percentualValorImovel){
            imprimirPropostaAprovada();
        }else{
            imprimirPropostaNegada();
        }
    }

    private void imprimirPropostaAprovada(){
        System.out.println("Parabéns " + this.beneficiario.getNome() + "!" + " Sua proposta foi aprovada!");
        System.out.println("#### Detalhes da proposta ####");
        System.out.println("Beneficiário: " + this.beneficiario.getNome() + ".");
        System.out.println("Imóvel: " + this.imovel.apresentacao());
        System.out.println("Prazo para pagamento: " + this.mesesParaPagamento + " meses.");
    }

    private void imprimirPropostaNegada(){
        System.out.println("Não foi dessa vez " + this.beneficiario.getNome() + "!" + " Sua proposta foi negada!");
        System.out.println("Vai dar um jeito de aumentar esse salário! Quer comprar imóvel ganhando uma mixaria e " +
                "pagar em " + this.mesesParaPagamento + " meses?!");
        System.out.println("#### Detalhes da proposta ####");
        System.out.println("Beneficiário: " + this.beneficiario.getNome() + ".");
        System.out.println("Imóvel: " + this.imovel.apresentacao());
        System.out.println("Prazo para pagamento: " + this.mesesParaPagamento + " meses.");
    }
}