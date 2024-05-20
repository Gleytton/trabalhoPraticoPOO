import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Arquivo {

    String caminho = "";

    public String Read(String caminho) { // função de LEITURA
        StringBuilder conteudo = new StringBuilder();
        try {
            FileReader arq = new FileReader(caminho);
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