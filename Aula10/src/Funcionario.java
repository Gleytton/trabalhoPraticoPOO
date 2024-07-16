public class Funcionario extends Pessoa{

    private String setor;
    private boolean trabalhando;

    public String getSetor(){
        return this.setor;
    }
    public void setSetor(String setor){
        this.setor = setor;
    }
    public boolean getTrabalhando(){
        return this.trabalhando;
    }
    public void setTrabalhando(boolean trabalhando){
        this.trabalhando = trabalhando;
    }

    public Funcionario(String nome, int idade, String sexo, String setor, boolean trabalhando){
        super(nome, idade, sexo);
        this.setSetor(setor);
        this.setTrabalhando(trabalhando);
    }

    public void mudarTrabalho(boolean trabalhando){
        this.setTrabalhando(trabalhando);
    }
}
