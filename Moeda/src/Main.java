import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        int moeda,valor100,valor50,valor25,valor10,valor5,valor1;

        int aux;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o valor em centavos: ");
        moeda = teclado.nextInt();

        valor100 = moeda/100;

        aux = moeda%100;

        valor50 = aux/50;

        aux = aux % 50;

        valor25 = aux/25;

        aux = aux % 25;

        valor10 = aux/10;

        aux = aux % 10;

        valor5 = aux/5;

        aux = aux % 5;

        valor1 = aux/1;

        aux = aux % 1;


        System.out.println("O valor de " + moeda + " é formado por:" );
        System.out.println(valor100 + " moedas de 1 Real");
        System.out.println(valor50 + " moedas de 50 centavos");
        System.out.println(valor25 + "moedas de 25 centavos");
        System.out.println(valor10 + "moedas de 10 centavos");
        System.out.println(valor5  + "moedas de 5 centavos");
        System.out.println(valor1 + "moedas de 1 centavos");
    }
}