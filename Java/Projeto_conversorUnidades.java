import java.util.Scanner;
import java.util.Locale;

/*
8. Conversor de unidades

Converte temperatura (°C ↔ °F ↔ K), distância (km ↔ milhas), peso (kg ↔ lb)
— menu com switch e cálculos com double.
*/
public class Projeto_conversorUnidades {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int categoria = 0;
        while (categoria != 4){
            System.out.println("\n===== CONVERSOR =====");
            System.out.println("1 - Temperatura");
            System.out.println("2 - Distância");
            System.out.println("3 - Peso");
            System.out.println("4 - Sair");
            System.out.println("Escolha: ");
            categoria = scanner.nextInt();

            switch (categoria){
                case 1:
                    System.out.println("\n--- TEMPERATURA ---");
                    System.out.println("1 - Celsius para Fahrenheit");
                    System.out.println("2 - Fahrenheit para Celsius");
                    System.out.println("3 - Celsius para Kelvin");
                    System.out.println("4 - Kelvin para Celsius");
                    System.out.println("Escolha: ");
                    int opcaoTemp = scanner.nextInt();

                    System.out.println("Digite o valor: ");
                    double valorT = scanner.nextDouble();

                    switch (opcaoTemp){
                        case 1:
                            System.out.printf("Resultado: %.2f °F%n", (valorT * 9.0/5.0) + 32);
                            break;
                        case 2:
                            System.out.printf("Resultado: %.2f °C%n", (valorT - 32) * 5.0/9.0);
                            break;
                        case 3:
                            System.out.printf("Resultado: %.2f K%n", valorT + 273.15);
                            break;
                        case 4:
                            System.out.printf("Resultado: %.2f °C%n", valorT - 273.15);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DISTÂNCIA ---");
                    System.out.println("1 - KM para Milhas");
                    System.out.println("2 - Milhas para KM");
                    System.out.println("Escolha: ");
                    int opcaoDis = scanner.nextInt();

                    System.out.println("Digite o valor: ");
                    double valorD = scanner.nextDouble();

                    switch (opcaoDis){
                        case 1:
                            System.out.printf("Resultado: %.2f milhas%n", valorD * 0.621371);
                            break;
                        case 2:
                            System.out.printf("Resultado: %.2f km%n", valorD * 1.60934);
                            break;
                        default:
                            System.out.printf("Opção inválida!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- PESO ---");
                    System.out.println("1 - KG para LB(libra)");
                    System.out.println("2 - LB(libra) para KG");
                    System.out.println("Escolha: ");
                    int opcaoPeso = scanner.nextInt();

                    System.out.println("Digite o valor: ");
                    double valorP = scanner.nextDouble();

                    switch (opcaoPeso){
                        case 1:
                            System.out.printf("Resultado: %.2f libras%n", valorP * 2.20462);
                            break;
                        case 2:
                            System.out.printf("Resultado: %.2f kg%n", valorP / 2.20462);
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
            }
        }
    }
}
