import java.util.Scanner;

/*
Calculadora no terminal
Recebe dois números e uma operação (+, -, *, /) via Scanner, usa switch para executar e imprime o resultado.
 */

public class Projeto_Calculadora {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();

        System.out.println("Digite o segundo número: ");
        double num2 = scanner.nextDouble();

        System.out.println("Digite a operação ( +  -  *  /  % ): ");
        char operacao = scanner.next().charAt(0);

        double resultado;

        switch (operacao){
            case '+':
                resultado = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + resultado);
                break;
            case '-':
                resultado = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + resultado);
                break;
            case '*':
                resultado = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + resultado);
                break;
            case '/':
                resultado = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + resultado);
                break;
            case '%':
                resultado = num1 % num2;
                System.out.println(num1 + " % " + num2 + " = " + resultado);
                break;
            default:
                System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}


