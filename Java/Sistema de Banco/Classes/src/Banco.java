public class Banco {
    private String nome;
    private ContaBancaria[] contas;
    private int quantidadeContas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ContaBancaria[10];
        this.quantidadeContas = 0;
    }

    public void adicionarConta(ContaBancaria conta){
        contas[quantidadeContas] = conta;
        quantidadeContas++;
    }

    public ContaBancaria buscarConta(String titular) {
        for (int i = 0; i < quantidadeContas; i++) {
            if (contas[i].getTitular().equals(titular)) {
                return contas[i];
            }
        }
        return null;
    }

    public ContaBancaria[] getContas() {
        return contas;
    }

    public int getQuantidadeContas() {
        return quantidadeContas;
    }
}
