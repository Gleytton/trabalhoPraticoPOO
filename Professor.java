import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Professor extends Pessoa {

    private String idProfessor;

    public String getIdProfessor(){
        return this.idProfessor;
    }
    public void setIdProfessor(String idProfessor){
        this.idProfessor = idProfessor;
    }
    public Professor(String nome, String login, String senha, String idProfessor){

        super(nome, login, senha);
        this.setIdProfessor(idProfessor);
    }

    public void GravarQuestões(){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Escolha o nivel da pergunta:");
        int nivel =  teclado.nextInt();
        System.out.println("Digite a pergunta:");
        String pergunta = teclado.nextLine();
        System.out.println("Alternativa A: ");
        String opcA = teclado.nextLine();
        System.out.println("Alternativa B: ");
        String opcB = teclado.nextLine();
        System.out.println("Alternativa C: ");
        String opcC = teclado.nextLine();
        System.out.println("Alternativa D: ");
        String opcD = teclado.nextLine();
        System.out.println("Resposta correta: ");
        String resposta = teclado.nextLine();

        Random aleatorio = new Random();
        int idPergunta = aleatorio.nextInt(1000);

        List<Pergunta> lp = new ArrayList<>();
        lp.add(new Pergunta(nivel,pergunta,opcA,opcB,opcC,opcD,resposta,idPergunta));

        String caminho = "perguntas.txt";
        try {
            FileWriter arq = new FileWriter(caminho, true);
            BufferedWriter escArq = new BufferedWriter(arq);
            PrintWriter pw = new PrintWriter(escArq);

            pw.print(lp.getFirst().getNivel() + "," + lp.getFirst().getIdPergunta()+","+ lp.getFirst().getOpcA()+","+ lp.getFirst().getOpcB()+","
                    + lp.getFirst().getOpcC()+","+ lp.getFirst().getOpcD()+ ","+ lp.getFirst().getResposta()+","+lp.getFirst().getIdPergunta());
        }
        catch (IOException ex){

            System.out.println("Erro: Não foi possível escrever arquivo");
        }



    }
}

