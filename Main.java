import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        //MEGAMENU

        System.out.println("-------------------------------------");
        System.out.println("|        Duolingo da Shopee         |");
        System.out.println("-------------------------------------");
        System.out.println("|Selecione a Opção que deseja:      |\n" +
                "|[1] Cadastrar novo usuario         |\n" +
                "|[2] Login      |\n" );
        System.out.println("Digite sua opcao:");

        int opcao = teclado.nextInt();

        switch(opcao){

            case 1:
                Pessoa p = new Pessoa();
                p.cadastro();
                break;
            case 2:
                boolean b = true;
                while(b == true) {
                    System.out.println("Digite seu login:");
                    String login = teclado.nextLine();
                    System.out.println("Digite sua senha:");
                    String senha = teclado.nextLine();
                    // fazer algo para comprovar se login e senha estão corretos
                }
            default:
                System.out.println("ERRO: Opção não existe!!!");
                break;

        }



    }
}
