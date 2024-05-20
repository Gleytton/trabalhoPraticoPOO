import java.io.*;
import java.util.*;

public class Main {
    private static final String USUARIOS_FILE = "usuario.txt";

    private static Map<String, Pessoa> loadPessoa() throws IOException {
        Map<String, Pessoa> pessoas = new HashMap<>();
        File arquivo = new File(USUARIOS_FILE);
        if (!arquivo.exists()) {
            arquivo.createNewFile();
            return pessoas;
        }
        return pessoas;
    }

    private static Pessoa registrarNovaPessoa(Scanner input) {
        System.out.println("|      Cadastre o novo usuario      |");
        System.out.println("-------------------------------------");
        System.out.print("|Nome: ");
        String nome = input.nextLine();
        System.out.print("|Login: ");
        String login = input.nextLine();
        System.out.print("|Senha: ");
        String senha = input.nextLine();
        System.out.print("|Tipo de usuário:\n" +
                "|(1) Aluno\n" +
                "|(2) Professor\n" +
                "|");
        int opcao = input.nextInt();
        if (opcao == 1) {
            int nivel = 1;
            return new Aluno(nome, login, senha, nivel);
        } else {
            return new Professor(nome, login, senha);
        }


    }
    private static void salvarPessoa(Map<String, Pessoa> pessoas) throws IOException{
        BufferedWriter escrivao = new BufferedWriter(new FileWriter(USUARIOS_FILE));

        for (Pessoa pessoa : pessoas.values()) {
            escrivao.write(pessoa.getNome() + "," + pessoa.getLogin() + "," + pessoa.getSenha());
            escrivao.newLine();
        }
        escrivao.close();
    }


    public static void main(String[] args) throws IOException {
        Map<String, Pessoa> pessoa = loadPessoa();
        Scanner input = new Scanner(System.in);

        if (pessoa.isEmpty()) {
            System.out.println("-------------------------------------");
            System.out.println("| Não foi encontrado nenhum usuario |");
            System.out.println("-------------------------------------");
            Pessoa novaPessoa = registrarNovaPessoa(input);
            pessoa.put(novaPessoa.getLogin(),novaPessoa);
            salvarPessoa(pessoa);
        }

        //MEGAMENU

        System.out.println("-------------------------------------");
        System.out.println("|        Duolingo da Shopee         |");
        System.out.println("-------------------------------------");
        System.out.println("|Selecione a Opção que deseja:      |\n" +
                           "|[1] Cadastrar novo usuario         |\n" +
                           "|[2] Cadastrar nova pergunta        |\n" +
                           "|[3] Deletar usuario                |\n" +
                           "|[4] Deletar pergunta               |\n");


        //Arquivo.writeToFile("output.txt", "Hello, World!"); // para fazermos saida em arquivos.
    }
}
