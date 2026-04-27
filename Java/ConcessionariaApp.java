import java.util.Scanner;

class Carro {
    public String nome;
    public String modelo;
    public int ano;
    public double preco;
}

class Concessionaria {

    public Carro[] carros;

    public void exibirTodos() {
        System.out.println("\n===== CARROS DA CONCESSIONARIA =====");
        for (Carro carro : carros) {
            System.out.println("------------------------------------");
            System.out.println("Nome:   " + carro.nome);
            System.out.println("Modelo: " + carro.modelo);
            System.out.println("Ano:    " + carro.ano);
            System.out.println("Preço:  R$ " + carro.preco);
        }
        System.out.println("====================================");
    }

    public void buscarPorNome(String nomeBuscado) {
        System.out.println("\n===== BUSCANDO: " + nomeBuscado + " =====");
        boolean encontrou = false;
        for (Carro carro : carros) {
            if (carro.nome.equalsIgnoreCase(nomeBuscado)) {   // equalsIgnoreCase -> ignora letra maiuscula e minuscula
                System.out.println("Carro encontrado!");
                System.out.println("Nome:   " + carro.nome);
                System.out.println("Modelo: " + carro.modelo);
                System.out.println("Ano:    " + carro.ano);
                System.out.println("Preço:  R$ " + carro.preco);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum carro encontrado com o nome: " + nomeBuscado);
        }
    }

    public void calcularPrecoMedio() {
        System.out.println("\n===== PREÇO MÉDIO DA FROTA =====");
        double soma = 0;
        for (Carro carro : carros) {
            soma += carro.preco;
        }
        double media = soma / carros.length;
        System.out.println("Preço médio: R$ " + media);
    }
}

public class ConcessionariaApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Carro[] carros = new Carro[4];

        for (int i = 0; i < carros.length; i++) {
            Carro carro = new Carro();

            System.out.println("\n--- Cadastro do carro " + (i + 1) + " ---");

            System.out.print("Nome: ");
            carro.nome = scanner.nextLine();

            System.out.print("Modelo: ");
            carro.modelo = scanner.nextLine();

            System.out.print("Ano: ");
            carro.ano = scanner.nextInt();

            System.out.print("Preço: ");
            carro.preco = scanner.nextDouble();
            scanner.nextLine();

            carros[i] = carro;
        }

        Concessionaria concessionaria = new Concessionaria();
        concessionaria.carros = carros;

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Exibir todos os carros");
            System.out.println("2 - Buscar por nome");
            System.out.println("3 - Calcular preço médio");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                concessionaria.exibirTodos();
            } else if (opcao == 2) {
                System.out.print("Digite o nome: ");
                String nome = scanner.nextLine();
                concessionaria.buscarPorNome(nome);
            } else if (opcao == 3) {
                concessionaria.calcularPrecoMedio();
            }
        }

        System.out.println("Encerrando...");
        scanner.close();
    }
}
