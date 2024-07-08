public class Pessoa {

    public String[] nome = new String[20];
    private String login;
    private String senha;

    public Pessoa(String n, String l, String s){
        this.setNome(n);
        this.setLogin(l);
        this.setSenha(s);
    }

    public String[] getNome() {return this.nome;}

    public void setNome(String[] n) {
        this.nome = n;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String l) {
        this.login = l;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String s) {
        this.senha = s;
    }

    public void cadastro(String[] n, String l, String s){

        Pessoa p1 = new Pessoa(n,l,s);
    }

    public void login(Pessoa p1){


    }
}

