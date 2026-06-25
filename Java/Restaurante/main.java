import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante("Restaurante");

        int opcao = 0;
        while (opcao != 6) {
            System.out.println("========= MENU =========\n");
            System.out.println("1 - Abrir pedido");
            System.out.println("2 - Adicionar item ao pedido");
            System.out.println("3 - Atualizar status do pedido");
            System.out.println("4 - Ver pedido da mesa");
            System.out.println("5 - Fechar e pagar o pedido");
            System.out.println("6 - Sair");
            System.out.println("Escolha: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da mesa: ");
                    int numeroMesa = scanner.nextInt();
                    restaurante.abrirPedido(numeroMesa);

                    System.out.println("Pedido iniciado com sucesso! ");
                    break;

                case 2:
                    System.out.println("Informe o número da mesa para prosseguir: ");
                    numeroMesa = scanner.nextInt();
                    Pedido pedido = restaurante.buscarPedido(numeroMesa);
                    if (pedido == null) {
                        System.out.println("Mesa não encontrada! ");
                        break;
                    }
                    ItemCardapio[] cardapio = restaurante.getCardapio();
                    for (int i = 0; i < cardapio.length; i++) {
                        System.out.println(i + " - " + cardapio[i]);
                    }
                    System.out.println("Escolha um item do cardápio: ");
                    int escolha = scanner.nextInt();

                    pedido.adicionarItem(cardapio[escolha]);
                    System.out.println("Item adicionado! ");

                    break;

                case 3:
                    System.out.println("Informe o número da mesa para prosseguir: ");
                    numeroMesa = scanner.nextInt();

                    pedido = restaurante.buscarPedido(numeroMesa);
                    if (pedido == null) {
                        System.out.println("Mesa não encontrada! ");
                        break;
                    }
                    StatusPedido[] status = StatusPedido.values();
                    for (int i = 0; i < status.length; i++) {
                        System.out.println(i + " - " + status[i]);
                    }
                    System.out.println("Escolha o novo status: ");
                    int escolhaStatus = scanner.nextInt();

                    pedido.setStatus(status[escolhaStatus]);
                    System.out.println("Status atualizado! ");
                    break;

                case 4:
                    System.out.println("Informe o número da mesa para prosseguir: ");
                    numeroMesa = scanner.nextInt();
                    pedido = restaurante.buscarPedido(numeroMesa);
                    if (pedido == null) {
                        System.out.println("Mesa não encontrada! ");
                        break;
                    }
                    System.out.println(pedido);
                    break;

                case 5:
                    System.out.println("Informe o número da mesa para prosseguir: ");
                    numeroMesa = scanner.nextInt();
                    pedido = restaurante.buscarPedido(numeroMesa);
                    if (pedido == null) {
                        System.out.println("Mesa não encontrada! ");
                        break;
                    }
                    System.out.println("------ Total ------\nR$" + pedido.calcularTotal());

                    pedido.setStatus(StatusPedido.ENTREGUE);
                    System.out.println("Pedido encerrado! ");
                    break;

                case 6:
                    break;
                default:
                    System.out.println("Opção inválida! ");
            }
        }

        System.out.println("Encerrando...");
        scanner.close();
    }
}
