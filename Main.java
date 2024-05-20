import java.io.*;
import java.util.*;

public class Main {

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
