import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;


public class ArquivoProfessor {


    public Professor Write(){

        private static final String USUARIOS_FILE = "professor.txt";

        private static Map<String, Pessoa> loadPessoa() throws IOException {
            Map<String, Pessoa> pessoas = new HashMap<>();
            File arquivo = new File(USUARIOS_FILE);
            if (!arquivo.exists()) {
                arquivo.createNewFile();
                return pessoas;
            }
            return pessoas;
        }

        public static Pessoa registrarNovaPessoa(Scanner input) {
            System.out.println("|      Cadastre o novo professor      |");
            System.out.println("-------------------------------------");
            System.out.print("|Nome: ");
            String nome = input.nextLine();
            System.out.print("|Login: ");
            String login = input.nextLine();
            System.out.print("|Senha: ");
            String senha = input.nextLine();
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

        String USUARIOS_FILE = "professor.txt";

    public String Read(String USUARIOS_FILE) { // função de LEITURA
        StringBuilder conteudo = new StringBuilder();
        try {
            FileReader arq = new FileReader(USUARIOS_FILE);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    conteudo.append(linha);
                    linha = lerArq.readLine();
                }

                arq.close();
            } catch (IOException ex) {
                conteudo = new StringBuilder("Erro: Não foi possível ler arquivo");
            }
            if (conteudo.toString().contains("Erro")) {
                return "";
            } else {
                return conteudo.toString();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}