public class Livro implements Publicacao{
    private String titulo;
    private String autor;
    private int totPag;
    private int pagAtual;
    private boolean aberto;
    private Pessoa leitor;

    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public String getAutor(){
        return this.autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public int getTotPag(){
        return this.totPag;
    }
    public void setTotPag(int totPag){
        this.totPag = totPag;
    }
    public int getPagAtual(){
        return this.pagAtual;
    }
    public void setPagAtual(int pagAtual){
        this.pagAtual = pagAtual;
    }
    public boolean getAberto(){
        return this.aberto;
    }
    public void setAberto(boolean aberto){
        this.aberto = aberto;
    }
    public Pessoa getLeitor(){
        return this.leitor;
    }
    public void setLeitor(Pessoa leitor){
        this.leitor= leitor;
    }

    public Livro(String titulo, String autor, int totPag, int pagAtual, boolean aberto, Pessoa leitor){

        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setTotPag(totPag);
        this.setPagAtual(pagAtual);
        this.setAberto(aberto);
        this.setLeitor(leitor);
    }

    public boolean abrir(){
        this.setAberto(true);
        return this.getAberto();
    }
    public boolean fechar(){
        this.setAberto(false);
        return this.getAberto();
    }
    public void folhear(int pag){
        this.setPagAtual(this.getPagAtual() + pag);

    }
    public int avancarPag(){
        this.setPagAtual(this.getPagAtual() + 1);
        return this.getPagAtual();
    }
    public int voltarPag(){
        this.setPagAtual(this.getPagAtual() - 1);
        return this.getPagAtual();
    }

    public void detalhes(){
        System.out.println("Titulo: " + this.getTitulo()
        + "\nAutor: " + this.getAutor()
        + "\nTotal de paginas: " + this.getTotPag()
        + "\nPagina atual: "+ this.getPagAtual()
        + "\nAberto: " + this.getAberto()
        + "\nLeitor: " + this.leitor.getNome());

    }
}
