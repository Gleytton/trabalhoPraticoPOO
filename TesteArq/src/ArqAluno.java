import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ArqAluno {
 public static String Reader(String caminho){

     String conteudo = "";

     try{
         FileReader arq = new FileReader(caminho);
         BufferedReader lerArq = new BufferedReader(arq);
         String linha = "";
         try{

             linha = lerArq.readLine();
             while(linha != null){
                 conteudo += linha;
                 linha = lerArq.readLine();
             }
             arq.close();
         }
         catch(IOException e){
             conteudo = "ERRO: Não foi possível ler arquivo";
         }
     }catch (FileNotFoundException e){
            conteudo = "ERRO: Arquivo não encontrado";
     }
     if(conteudo.contains("ERRO")){
         return "";
     }
     else{
         return conteudo;
     }
 }

 public static boolean Writer(String caminho, String nome, String login, String senha){
    try {
        FileWriter arq = new FileWriter(caminho);
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.println(nome);
        gravarArq.println(login);
        gravarArq.println(senha);
        gravarArq.close();
        return true;
    }catch (IOException e){
        System.out.println(e.getMessage());
        return false;
    }

 }

}
