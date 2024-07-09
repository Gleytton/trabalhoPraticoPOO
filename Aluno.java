import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Aluno extends Pessoa {

    private int nivelAtual;
    private int licaoFeita;

    public int getNivelAtual() {
        return this.nivelAtual;
    }
    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public int getLicaoFeita() {
        return this.licaoFeita;
    }

    public void setLicaoFeita(int licao) {
        this.licaoFeita = licao;
    }

    public Aluno(String nome, String login, String senha,String tipo, int nivelAtual, int licaoFeita){
        super(nome, login, senha,tipo);
        this.setNivelAtual(nivelAtual);
        this.setLicaoFeita(licaoFeita);
    }
    String caminho = "perguntas.txt";

    public void receberPergunta(){

        FileReader arq = new FileReader(caminho);
        BufferedReader lerArq = new BufferedReader(arq);
        List<Pergunta> p = new ArrayList<>();
        p.
        if (this.getNivelAtual() == )

    }


}

