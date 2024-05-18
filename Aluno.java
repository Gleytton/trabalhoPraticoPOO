public class Aluno extends Pessoa{

    String[] mat = new String[5];
    int nivel, licao;
    float nota;

    private String[] getMat() {
        return this.mat;
    }
    private void setMat( String[] m){
        this.mat = m;
    }
    public int getNível(){
        return this.nivel;
    }
    public void setNivel(int n){
        this.nivel = n;
    }

    public int getLicao(){
        return this.licao;
    }
    public void setLicao(int l){
        this.licao = l;
    }

    public float getNota(){
        return this.nota;
    }
    
    public void serNota(float n){
        this.nota = n
    }
}
