import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Pessoa {

    private String nome,login, senha, tipo;


    public String getNome() {return this.nome;}

    public void setNome(String n) {
        this.nome = n;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String l) {
        this.login = l;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String s) {
        this.senha = s;
    }

    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public Pessoa(String nome, String login, String senha, String tipo){
        this.setNome(nome);
        this.setLogin(login);
        this.setSenha(senha);
        this.setTipo(tipo);
    }
    Scanner teclado = new Scanner(System.in);

    public void cadastro(){

        Pessoa p = new Pessoa(nome,login,senha,tipo);

        System.out.print("Digite seu nome: ");
        this.setNome(teclado.nextLine());
        System.out.print("Digite seu login: ");
        this.setLogin(teclado.nextLine());
        System.out.print("Digite sua senha:");
        this.setSenha(teclado.nextLine());
        System.out.print("Usuário: Aluno ou Professor");
        this.setTipo(teclado.nextLine());

        List<Pessoa> p1 = new ArrayList<>();
        p1.add(new Pessoa(this.getNome(),this.getLogin(), this.getSenha(), this.getTipo()));

        String caminho = "usuario.txt";
        try {
            FileWriter arq = new FileWriter(caminho);
            BufferedWriter escArq = new BufferedWriter(arq);
            PrintWriter pw = new PrintWriter(escArq);

            pw.print(p1.getFirst().getNome()+","+p1.getFirst().getLogin()+","+p1.getFirst().getSenha()+","
                    +p1.getFirst().getTipo());
        }
        catch (IOException ex){

            System.out.println("Erro: Não foi possível escrever arquivo");
        }
    }



}

