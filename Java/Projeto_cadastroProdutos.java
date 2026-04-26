import java.util.Scanner;
import java.util.Locale;

/*
Cadastro de produtos simples Array de produtos (nome, preço, quantidade),
menu para listar, buscar por nome, mostrar o mais caro/barato. Me ajude a começar este projeto
 */

public class Projeto_cadastroProdutos {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.println("Quantos produtos deseja cadastrar? ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();                    // limpa o buffer
        String [] nomes = new String[quantidade];
        double[] precos = new double[quantidade];
        int[] estoque = new int[quantidade];

        // Cadastro
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n--- Produto " + (i + 1) + " ---");

            System.out.println("Nome: ");
            nomes[i] = scanner.nextLine();

            System.out.println("Preço: ");
            precos[i] = scanner.nextDouble();

            System.out.println("Quantidade em estoque: ");
            estoque[i] = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Produtos cadastrados com sucesso!");

        //Menu principal
        int opcao = 0;
        while (opcao != 4){
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Listar produtos");
            System.out.println("2 - Buscar por nome");
            System.out.println("3 - Maior e menor preço");
            System.out.println("4 - Sair");
            System.out.println("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < quantidade; i++) {
                        System.out.println("\nNome: " + nomes[i]);
                        System.out.printf("Preço: R$ %.2f%n",  precos[i]);
                        System.out.println("Estoque: " + estoque[i]);
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do produto: ");
                    String busca = scanner.nextLine();
                    boolean encontrado = false;

                    for (int i = 0; i < quantidade; i++) {
                        if (nomes[i].equalsIgnoreCase(busca)){
                            System.out.println("\nProduto encontrado!");
                            System.out.println("\nNome: " + nomes[i]);
                            System.out.printf("Preço: R$ %.2f%n", precos[i]);
                            System.out.println("Estoque: " + estoque[i]);
                            encontrado = true;
                            break;
                        }
                    }if (!encontrado){
                    System.out.println("Produto não encontrado!");
                    }
                    break;
                case 3:
                    int indiceMaior = 0;
                    int indiceMenor = 0;
                    for (int i = 1; i < quantidade; i++) {
                        if (precos[i] > precos[indiceMaior]){
                            indiceMaior = i;
                        }
                        if (precos[i] < precos[indiceMenor]){
                            indiceMenor = i;
                        }
                    }
                    System.out.println("\n--- MAIOR PREÇO ---");
                    System.out.println("Nome: " + nomes[indiceMaior]);
                    System.out.printf("Preço: R$ %.2f%n", precos[indiceMaior]);
                    System.out.println("Estoque: " + estoque[indiceMaior]);

                    System.out.println("\n--- MENOR PREÇO ---");
                    System.out.println("Nome: " + nomes[indiceMenor]);
                    System.out.printf("Preço: R$ %.2f%n", precos[indiceMenor]);
                    System.out.println("Estoque: " + estoque[indiceMenor]);
                    break;
                case 4:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
