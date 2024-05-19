import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Arquivo {

     String caminho = "https://github.com/Gleytton/trabalhoPraticoPOO";
     public String Read(String caminho){ // função de LEITURA
          String conteudo = "";
          try{
               FileReader arq = new FileReader(caminho);
               BufferedReader lerArq = new BufferedReader(arq);
               String linha = "";
               try{

                    linha = lerArq.readLine();
                    while(linha!= null){
                          conteudo += linha;
                          linha = lerArq.readLine();
                    }

                    arq.close();
               }
               catch (IOException ex){

                    conteudo = "Erro: Não foi possível ler arquivo";
               }
               if (conteudo.contains("Erro")){
                    return "";
               }else{

                    return conteudo;
               }
          }

     }

     public void Write(String arq, String caminho){



     }
}