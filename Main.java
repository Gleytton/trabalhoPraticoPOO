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
                int selecao;
                System.out.println("Deseja cadastrar um aluno[1] ou professor[2]?");
                System.out.println("Digite sua opcao:");
                selecao = teclado.nextInt();
                    switch(selecao){
                    case 1:

                        int loop = 1;
                        while(loop == 1){
                            System.out.printf("Digite o nome do Aluno:");
                            teclado.nextLine();
                            String nome = teclado.nextLine();
                            System.out.printf("Digite o login do Aluno:");
                            String login = teclado.nextLine();
                            System.out.printf("Digite a senha do Aluno: ");
                            String senha = teclado.nextLine();
                            System.out.printf("Digite o nivel do Aluno: ");
                            int nivel = teclado.nextInt();

                            Aluno a1 = new Aluno(nome, login, senha, nivel);

                            ArquivoAluno.Writer("aluno.txt", nome, login, senha, nivel);

                            System.out.println("Deseja cadastrar outro Aluno??? ");
                            System.out.println("SIM (1)");
                            System.out.println("NAO (2)");
                            System.out.print("Digite sua opcao:");
                            loop = teclado.nextInt();
                        }

                        break;
                    case 2:
                        boolean status = true;
                        while(status == true){
                        System.out.println("Digite o nome do Professor:");
                        String nome = teclado.nextLine();
                        System.out.println("Digite o login do Professor:");
                        String login = teclado.nextLine();
                        System.out.println("Digite a senha do Professor:");
                        String senha = teclado.nextLine();

                        Professor p1 = new Professor(nome, login, senha);

                        ArquivoProfessor.writer("professor.txt", nome, login, senha);

                        System.out.println("Deseja cadastrar outro Professor??? ");
                        System.out.println("SIM (1)");
                        System.out.println("NAO (2)");
                        loop = teclado.nextInt();
                        }
                    break;
                default:
                    System.out.println("ERRO: Opção não existe!!!");
                    break;

            }
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
