import java.io.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Banco {
    private String nome;
    private Map<String, ContaBancaria> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new LinkedHashMap<>();
    }

    public void adicionarConta(ContaBancaria conta) throws CpfJaCadastradoException {
        boolean cpfExiste = contas.containsKey(conta.getCpf());
        if (cpfExiste) {
            throw new CpfJaCadastradoException("Já existe uma conta com o CPF " + conta.getCpf() + " cadastrado");
        }
        contas.put(conta.getCpf(), conta);
    }

    public ContaBancaria buscarConta(String cpf) throws ContaNaoEncontradaException {
        ContaBancaria conta = contas.get(cpf);
        if (conta == null) {
            throw new ContaNaoEncontradaException("Nenhuma conta encontrada para o CPF: " + cpf);
        }

        return conta;
    }

    public void removerConta(String cpf) throws ContaNaoEncontradaException, ContaComSaldoException {
        ContaBancaria conta = contas.get(cpf);
        if (conta == null) {
            throw new ContaNaoEncontradaException("Nenhuma conta encontrada para o CPF: " + cpf);
        }

        if (conta.getSaldo() > 0) {
            throw new ContaComSaldoException("Não é possível deletar conta com saldo positivo. Saldo atual: R$" + conta.getSaldo());
        }

        contas.remove(cpf);
    }

    public void salvar() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("contas.txt"))) {
            for (ContaBancaria conta : contas.values()) {
                String linha = conta.getTipoConta().name() + ";" + conta.getTitular() + ";" + conta.getSaldo() + ";" + conta.getCpf() + ";" + conta.getEmail() + ";" + conta.getDataAbertura();

                writer.write(linha);
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar dados " + e.getMessage());
        }
    }

    public void carregar() {
        try (BufferedReader reader = new BufferedReader(new FileReader("contas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(";");
                TipoConta tipo = TipoConta.valueOf(campos[0]);
                String titular = campos[1];
                double saldo = Double.parseDouble(campos[2]);
                String cpf = campos[3];
                String email = campos[4];
                LocalDate dataAbertura = LocalDate.parse(campos[5]);

                if (tipo == TipoConta.CORRENTE) {
                    ContaBancaria conta = new ContaCorrente(titular, saldo, cpf, email, dataAbertura);
                    contas.put(cpf, conta);

                } else if (tipo == TipoConta.POUPANCA) {
                    ContaBancaria conta = new ContaPoupanca(titular, saldo, cpf, email, dataAbertura);
                    contas.put(cpf, conta);

                } else {
                    ContaBancaria conta = new ContaInvestimento(titular, saldo, cpf, email, dataAbertura);
                    contas.put(cpf, conta);

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nenhum dado salvo ainda, iniciando banco vazio.");

        } catch (IOException | CpfInvalidoException | EmailInvalidoException e) {
            System.out.println("Erro ao carregar dados " + e.getMessage());
        }

    }

    public Collection<ContaBancaria> getContas() {
        return contas.values();
    }

    public int getQuantidadeContas() {
        return contas.size();
    }
}
