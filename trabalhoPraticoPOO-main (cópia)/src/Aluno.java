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
    }
    //getters & setters

    public int getTotalRespondidas() {
        return this.totalRespondidas;
    }

    public void setTotalRespondidas(int totalRespondidas) {
        this.totalRespondidas = totalRespondidas;
    }

    public int getNivelAtual() {
        return this.nivelAtual;
    }

    public void setNivelAtual(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }

    public int getAcertou() {
        return this.acertou;
    }

    public void setAcertou(int acertou) {
        this.acertou = acertou;
    }
}

