import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {

    private int nivelAtual;
    private int acertou;
    private int totalRespondidas;

    //construct
    public Aluno(String nome, String login, String senha, String tipo, ) {
        super(nome, login, senha,tipo);
        this.nivelAtual = 1;
        this.acertou = 0;
        this.totalRespondidas = 0;
    }

//    precisa disso ?
//    public void receberPergunta(){
//        String caminho = "perguntas.txt";
//        FileReader arq = new FileReader(caminho);
//        BufferedReader lerArq = new BufferedReader(arq);
//        List<Pergunta> p = new ArrayList<>();
//        p.
//        if (this.getNivelAtual() == )
//    }

    //getters & setters

    public int getTotalRespondidas() {
        return totalRespondidas;
    }

    public void setTotalRespondidas(int totalRespondidas) {
        this.totalRespondidas = totalRespondidas;
    }

    public int getNivelAtual() {
        return nivelAtual;
    }

    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public int getAcertou() {
        return acertou;
    }

    public void setAcertou(int acertou) {
        this.acertou = acertou;
    }
}

