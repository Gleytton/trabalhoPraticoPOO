import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;


public class ArquivoAluno {

    public Aluno Write(){

     public  static final String USUARIOS_FILE = "aluno.txt";

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
            System.out.println("|Nível:");
            int nivel = input.nextInt();
            return new Aluno(nome, login, senha,nivel);
        }

        String USUARIOS_FILE = "aluno.txt";

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