import java.io.*;

public class ArquivoAluno {
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

    public static boolean Writer(String caminho, String nome, String login, String senha, int nivel){

        FileWriter arq = null;

        try {
            if (arq == null) {
                arq = new FileWriter(caminho);
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.println(nome);
                gravarArq.println(login);
                gravarArq.println(senha);
                gravarArq.println(nivel);
                gravarArq.close();
                return true;

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        return false;
    }

}