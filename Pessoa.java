public class Pessoa {

    public String[] nome = new String[20];
    private String login;
    private String senha;
    public int idade;

    public String[] getNome(){
        return this.nome;
    }
    public void setNome(String[] n){
        this.nome = n;
    }
    private String getLogin (){
        return this.login;
    }
    private void setLogin(String l){
        this.login = l;
    }
    private String getSenha (){
        return this.senha;
    }
    private void setSenha (String s){
        this.senha = s;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int i){
        this.idade = i;
    }
}

