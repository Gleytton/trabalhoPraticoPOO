import java.util.Scanner;

public class Aluno extends Usuario {

    private int nivelAtual;
    private int acertou;
    private int totalRespondidas;

    //construct
    public Aluno(String nome, String login, String senha) {
        super(nome, login, senha);
        this.nivelAtual = 1; // Nível atual inicializado como 1
        this.acertou = 0; // Total de acertos inicializado como 0
        this.totalRespondidas = 0; // Total respondidas inicializado como 0

        Arquivos arquivos = new Arquivos();
        if (arquivos.alunoJaExiste(login)) {
            System.out.println("Usuario já cadastrado!");
        } else {
            arquivos.salvarAluno(this);
        }
    }

    //método criar aluno
    public void criarAluno() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite seu Nome: ");
        String nome = teclado.nextLine();
        System.out.println("Digite seu Login: ");
        String login = teclado.nextLine();
        System.out.println("Digite sua Senha: ");
        String senha = teclado.nextLine();

        Aluno aluno = new Aluno(nome, login, senha);

        if(alunoJaExiste(this.getLogin())){
            System.out.println("Usuario já cadastrado!");
        } else {
            salvarAluno(aluno);
        }

    }

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

