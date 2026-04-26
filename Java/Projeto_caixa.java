import java.util.Scanner;

/*
5. Simulador de caixa eletrônico
Saldo inicial, menu com opções: sacar, depositar, ver saldo.
Usa switch + loop para manter o menu ativo até o usuário sair.
 */

public class Projeto_caixa {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o saldo: ");
        double saldo = scanner.nextDouble();

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("----MENU----");
            System.out.println("1- Ver saldo");
            System.out.println("2- Sacar");
            System.out.println("3- Depositar");
            System.out.println("4- Sair");
            System.out.println("Digite a opção: ");
            opcao = scanner.nextInt();


            switch (opcao) {
                case 1:
                    System.out.printf("Saldo : R$ %.2f%n", saldo);
                    break;
                case 2:
                    System.out.println("Valor que deseja sacar: ");
                    double saque = scanner.nextDouble();
                    if (saque > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        saldo = saldo - saque;
                        System.out.println("Saque realizado! ");
                    }
                    break;
                case 3:
                    System.out.println("Valor que deseja depositar: ");
                    double deposito = scanner.nextDouble();
                    saldo = saldo + deposito;
                    System.out.println("Deposito realizado!");
                    break;
                case 4:
                    System.out.println("Encerando...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
        scanner.close();
    }
}


