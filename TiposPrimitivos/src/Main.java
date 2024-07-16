import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        float salario = (float)2500.00;
        String nome = "Gleytton";
        System.out.printf("O salário de %s é %.2f: ", nome,salario);
        System.out.println();

        System.out.println("Digite um salário ideal: ");
        System.out.println();

        Scanner teclado = new Scanner(System.in);

        salario = teclado.nextFloat();

        System.out.printf("O salario ideal é %.2f", salario);
        System.out.println();



    }
}