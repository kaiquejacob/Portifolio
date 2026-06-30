public enum TipoConta {
    CORRENTE("Conta Corrente"),
    POUPANCA("Conta Poupança"),
    INVESTIMENTO("Conta de Investimento");

    public final String nome;

    TipoConta(String nome) {
        this.nome = nome;
    }
}
