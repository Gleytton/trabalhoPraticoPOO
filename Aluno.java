

public class Aluno extends Pessoa {

    public int nivel;

    public int getNivel() {
        return this.nivel;
    }

    public void setNivel(int lvl) {
        this.nivel = lvl;
    }

    public Aluno(String n, String l, String s, int lvl) {
        super(n, l, s);
        this.nivel = lvl;
    }

}




