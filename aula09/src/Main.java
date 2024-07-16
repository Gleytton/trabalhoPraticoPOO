public class Main {
    public static void main(String [] args){
        Pessoa p = new Pessoa("Zabeth", 37, "F");

        Livro l = new Livro("I Corintios","Paulo",20,0,false,p);
        l.setAberto(true);
        l.folhear(5);

        l.detalhes();

    }
}
