public class Aluno extends Usuario {

    private int nivelAtual;
    private int acertou;
    private int totalRespondidas;

    //construct
    public Aluno(String nome, String login, String senha, int nivelAtual,int acertou, int totalRespondidas) {
        super(nome, login, senha);
        this.setNivelAtual(nivelAtual); // Nível atual inicializado como 1
        this.setAcertou(acertou); // Total de acertos inicializado como 0
        this.setTotalRespondidas(totalRespondidas); // Total respondidas inicializado como 0

        Arquivos arquivos = new Arquivos();
        if (arquivos.alunoJaExiste(login)) {
            System.out.println("Usuario já cadastrado!");
        }
    }

    //método criar aluno
    public void criarAluno() {
            //salvarAluno(this.aluno);
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

