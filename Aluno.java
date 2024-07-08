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

    public Aluno(String nome, String login, String senha, int nivelAtual, int licaoFeita){
        super(nome, login, senha);
        this.setNivelAtual(nivelAtual);
        this.setLicaoFeita(licaoFeita);
    }

    public receberPergunta()


}

