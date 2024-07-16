import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ano, mes, dia, resultado;

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite a sua idade em ano, mês e dias:");
        System.out.println("Anos:");
        ano = teclado.nextInt();
        System.out.println("Mes:");
        mes = teclado.nextInt();
        System.out.println("Dias");
        dia = teclado.nextInt();

        resultado = (ano*365) + (mes*30) + (dia);

        System.out.println("Você tem " + resultado + "dias de vida");

    }
}