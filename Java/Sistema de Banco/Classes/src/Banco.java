import java.io.*;
import java.time.LocalDate;

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

    public void salvar(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("contas.txt"))){
            for (int i = 0; i < quantidadeContas; i++) {
                String linha = contas[i].getTipoConta().name() + ";" + contas[i].getTitular() + ";" + contas[i].getSaldo() + ";" + contas[i].getCpf() + ";" + contas[i].getEmail() + ";" + contas[i].getDataAbertura();

                writer.write(linha);
                writer.newLine();
            }

        }catch (IOException e){
            System.out.println("Erro ao salvar dados " + e.getMessage());
        }
    }

    public void carregar(){
        try(BufferedReader reader = new BufferedReader(new FileReader("contas.txt"))){
            String linha;
            while ((linha = reader.readLine()) != null){
                String[] campos = linha.split(";");
                TipoConta tipo = TipoConta.valueOf(campos[0]);
                String titular = campos[1];
                double saldo = Double.parseDouble(campos[2]);
                String cpf = campos[3];
                String email = campos[4];
                LocalDate dataAbertura = LocalDate.parse(campos[5]);

                if (tipo == TipoConta.CORRENTE){
                    ContaBancaria conta = new ContaCorrente(titular, saldo, cpf, email, dataAbertura);
                    contas[quantidadeContas] = conta;
                    quantidadeContas++;

                }else if (tipo == TipoConta.POUPANCA){
                    ContaBancaria conta = new ContaPoupanca(titular, saldo, cpf, email, dataAbertura);
                    contas[quantidadeContas] = conta;
                    quantidadeContas++;

                }else {
                    ContaBancaria conta = new ContaInvestimento(titular, saldo, cpf, email, dataAbertura);
                    contas[quantidadeContas] = conta;
                    quantidadeContas++;

                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Nenhum dado salvo ainda, iniciando banco vazio.");

        }catch (IOException | CpfInvalidoException | EmailInvalidoException e){
            System.out.println("Erro ao carregar dados " + e.getMessage());
        }

    }

    public ContaBancaria[] getContas() {
        return contas;
    }

    public int getQuantidadeContas() {
        return quantidadeContas;
    }
}
