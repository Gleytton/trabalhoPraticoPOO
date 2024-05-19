import java.util.Scanner;
public class Professor extends Pessoa {
    public Professor(){
        Scanner input = new Scanner(System.in);
        int opcao = 0;

        System.out.println("-----------Menu professor-----------");
        System.out.print("1: Adicionar nova pergunta\n" +
                "2: Remover pergunta");
        opcao = input.nextInt();

        switch (opcao){
            case 1:

        }


    }
}
