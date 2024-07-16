public final class Professor extends Pessoa{

    private String especialidade;
    private float salario;

    public String getEspecialidade(){
        return this.especialidade;
    }
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    public float getSalario(){
        return this.salario;
    }
    public void setSalario(float salario){
        this.salario = salario;
    }

    public Professor(String nome, int idade, String sexo, String especialidade, float salario){

        super(nome, idade, sexo);
        this.setEspecialidade(especialidade);
        this.setSalario(salario);
    }

    public void receberAumento(){
        this.setSalario((float) ((this.salario) + (0.1*this.salario)));

    }
}
