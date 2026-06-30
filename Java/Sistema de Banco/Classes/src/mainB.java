import java.util.Scanner;

public class mainB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco("Banco");

        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║   🏦 BANCO - MENU        ║");
            System.out.println("╠══════════════════════════╣");
            System.out.println("║ 1 - Criar conta          ║");
            System.out.println("║ 2 - Depositar            ║");
            System.out.println("║ 3 - Sacar                ║");
            System.out.println("║ 4 - Ver extrato          ║");
            System.out.println("║ 5 - Listar todas contas  ║");
            System.out.println("║ 6 - Sair                 ║");
            System.out.println("╚══════════════════════════╝");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("\n--- 📝 Criar Conta ---");
                    System.out.print("Nome do titular: ");
                    scanner.nextLine();                                              // limpa o buffer
                    String nomeTitular = scanner.nextLine();
                    System.out.print("Saldo inicial: R$");
                    double saldo = scanner.nextDouble();

                    System.out.println("\nTipos de conta disponíveis:\n");
                    TipoConta[] tipoConta = TipoConta.values();
                    for (int i = 0; i < tipoConta.length; i++) {
                        System.out.println(i + " - " + tipoConta[i].nome);
                    }

                    System.out.print("Escolha um tipo: ");
                    int escolhaConta = scanner.nextInt();

                    if (escolhaConta == 0){
                        banco.adicionarConta(new ContaCorrente(nomeTitular, saldo));
                    }else if (escolhaConta == 1) {
                        banco.adicionarConta(new ContaPoupanca(nomeTitular, saldo));
                    }else if (escolhaConta == 2) {
                        banco.adicionarConta(new ContaInvestimento(nomeTitular, saldo));
                    }else{
                        System.out.println("Opção inválida!");
                    }

                    System.out.println("Conta iniciado com sucesso! ");
                    break;

                case 2:
                    System.out.println("\n--- 💰 Depositar ---");
                    System.out.print("Nome do titular: ");
                    scanner.nextLine();                                                   // limpa o buffer
                    nomeTitular = scanner.nextLine();
                    ContaBancaria conta = banco.buscarConta(nomeTitular);
                    if (conta == null) {
                        System.out.println("Conta não encontrada! ");
                        break;
                    }
                    System.out.print("Valor a depositar: R$");
                    double valorDepositar = scanner.nextDouble();
                    conta.depositar(valorDepositar);
                    System.out.println("Depósito realizado com sucesso!");
                    break;

                case 3:
                    System.out.println("\n--- 💸 Sacar ---");
                    System.out.print("Nome do titular: ");
                    scanner.nextLine();                                                   // limpa o buffer
                    nomeTitular = scanner.nextLine();
                    conta = banco.buscarConta(nomeTitular);
                    if (conta == null) {
                        System.out.println("Conta não encontrada! ");
                        break;
                    }
                    System.out.print("Valor a sacar: R$");
                    double valorSacar = scanner.nextDouble();
                    conta.sacar(valorSacar);
                    System.out.println("Saque realizado com sucesso!");
                    break;

                case 4:
                    System.out.println("\n--- 📊 Extrato ---");
                    System.out.print("Nome do titular: ");
                    scanner.nextLine();                                                   // limpa o buffer
                    nomeTitular = scanner.nextLine();
                    conta = banco.buscarConta(nomeTitular);
                    if (conta == null) {
                        System.out.println("Conta não encontrada! ");
                        break;
                    }
                    conta.calcularExtrato();
                    break;

                case 5:
                    System.out.println("\n--- 📋 Todas as Contas ---");
                    ContaBancaria[] contas = banco.getContas();
                    if (banco.getQuantidadeContas() == 0) {
                        System.out.println("Nenhuma conta cadastrada.");
                        break;
                    }
                    for (int i = 0; i < banco.getQuantidadeContas(); i++) {
                        System.out.println(contas[i]);
                    }
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida!");

            }
        }

        System.out.println("Encerrando...");
        scanner.close();
    }
}
