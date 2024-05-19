public class Aluno extends Pessoa {

    private int nivelAtual;
    private int licaoFeita;

    public int getNível() {
        return this.nivelAtual;
    }

    public void setNivel(int n) {
        this.nivelAtual = n;
    }

    public int getLicao() {
        return this.licaoFeita;
    }

    public void setLicao(int l) {
        this.licaoFeita = l;
    }

}
