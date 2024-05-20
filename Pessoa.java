public class Pessoa {

    private final String nome;
    private final String login;
    private final String senha;


    public Pessoa(String n, String l, String s) {
        this.nome = n;
        this.login = l;
        this.senha = s;
    }

    public String getNome() {
        return this.nome;
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

}

