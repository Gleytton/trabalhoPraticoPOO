import java.security.PublicKey;

public class Bolsista extends Aluno{
    private  int bolsa;

    public int getBolsa(){
        return this.bolsa;
    }
    public void setBolsa(int bolsa){
        this.bolsa = bolsa;
    }
    public Bolsista(String nome, int idade, String sexo,String matricula, String curso, int bolsa){
        super(nome,idade,sexo,matricula,curso);
        this.setBolsa(bolsa);
    }
    @Override
    public void pagarMensalidade(){
        System.out.print("Pagando mensalidade bolsista");
    }
}
