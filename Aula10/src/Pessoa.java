public abstract class  Pessoa {
   private String nome;
   private int idade;
   private String sexo;

   public String getNome(){
       return this.nome;
   }
   public void setNome(String nome){
       this.nome = nome;
   }
   public int getIdade(){
       return this.idade;
   }
   public void setIdade(int idade){
       this.idade = idade;
   }
   public String getSexo(){
       return this.sexo;
   }
   public void setSexo(String sexo){
       this.sexo = sexo;
   }
   public Pessoa(String nome, int idade, String sexo){

       this.setNome(nome);
       this.setIdade(idade);
       this.setSexo(sexo);

    }

    public void fazerAniver(){
       this.setIdade(this.getIdade() + 1);
    }

    public String toString(){
        return "Nome:" + this.getNome() + "\nIdade: "+ this.getIdade() + "\nSexo: " + this.getSexo()+
                "\nMatricula: " + this.getMatricula() + "\nCurso: " + this.getCurso();
    }
}
