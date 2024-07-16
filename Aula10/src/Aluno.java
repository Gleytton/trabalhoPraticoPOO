public class Aluno extends Pessoa{

    private String matricula, curso;

    public String getMatricula(){
        return this.matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }
    public String getCurso(){
        return this.curso;
    }
    public void setCurso(String curso){
        this.curso = curso;
    }

    public Aluno(String nome, int idade, String sexo, String matricula, String curso){
        super(nome, idade,sexo);
        this.setMatricula(matricula);
        this.setCurso(curso);
    }

    public void cancelarMatricula(){
        this.setMatricula("Cancelada");
    }

    public void pagarMensalidade(){
        System.out.print("Pagando mensalidade!!!!");
    }


}
