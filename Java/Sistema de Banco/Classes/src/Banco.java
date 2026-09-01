public class Banco {
    private String nome;
    private ContaBancaria[] contas;
    private int quantidadeContas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ContaBancaria[10];
        this.quantidadeContas = 0;
    }

    public void adicionarConta(ContaBancaria conta ) throws CpfJaCadastradoException {
        for (int i = 0; i < quantidadeContas ; i++) {
            if (conta.getCpf().equals(contas[i].getCpf())){
                throw new CpfJaCadastradoException("Já existe uma conta com o CPF " + conta.getCpf() + " cadastrado");
            }
        }
        contas[quantidadeContas] = conta;
        quantidadeContas++;
    }

    public ContaBancaria buscarConta(String cpf) throws ContaNaoEncontradaException{
        for (int i = 0; i < quantidadeContas; i++) {
            if (contas[i].getCpf().equals(cpf)) {
                return contas[i];
            }
        }
        throw new ContaNaoEncontradaException("Nenhuma conta encontrada para o CPF: " + cpf);
    }

    public void removerConta(String cpf) throws ContaNaoEncontradaException, ContaComSaldoException {
        int indice = -1;
        for (int i = 0; i < quantidadeContas; i++) {
            if (contas[i].getCpf().equals(cpf)){
                indice = i;
                break;
            }
        }
        if (indice == -1){
            throw new ContaNaoEncontradaException("Nenhuma conta encontrada para o CPF: " + cpf);
        }

        if (contas[indice].getSaldo() > 0){
            throw new ContaComSaldoException("Não é possível deletar conta com saldo positivo. Saldo atual: R$" + contas[indice].getSaldo());
        }

        for (int i = indice; i < quantidadeContas - 1; i++) {
            contas[i] = contas[i + 1];
        }
        quantidadeContas--;

    }

    public ContaBancaria[] getContas() {
        return contas;
    }

    public int getQuantidadeContas() {
        return quantidadeContas;
    }
}
