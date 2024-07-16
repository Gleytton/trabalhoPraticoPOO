public class Lutador {

    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitoria;
    private int derrota;
    private int empate;

    public String getNome(){
        return this.nome;
    }
    public void setNome(String nm){
        this.nome = nm;
    }
    public String getNacionalidade(){
        return this.nacionalidade;
    }
    public void setNacionalidade(String nc){
        this.nacionalidade = nc;
    }
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int i){
        this.idade = i;
    }
    public float getAltura(){
        return this.altura;
    }
    public void setAltura(float a){
        this.altura = a;
    }
    public float getPeso(){
        return this.peso;
    }
    public void setPeso(float p){
        this.peso = p;
        if(this.getPeso() < 5.2){
            this.categoria = "Inválido";
        }
        else if (this.getPeso() <= 70.3){
            this.categoria = "Peso Leve";
        }
        else if(this.getPeso() <= 83.9){
            this.categoria = "Peso Médio";
        }
        else if(this.getPeso() > 83.9){
            this.categoria = "Peso Pesado";
        }
    }
    public String getCategoria(){
        return this.categoria;
    }


    public int getVitoria(){
        return this.vitoria;
    }
    public void setVitoria(int v){
        this.vitoria = v;
    }
    public int getDerrota(){
        return this.derrota;
    }
    public void setDerrota(int d){
        this.derrota = d;
    }
    public int getEmpate(){
        return this.empate;
    }
    public void setEmpate(int e){
        this.empate = e;
    }

    public Lutador(String nm, String nc, int i, float a, float p,int v, int d, int e){
        this.setNome(nm);
        this.setNacionalidade(nc);
        this.setIdade(i);
        this.setAltura(a);
        this.setPeso(p);
        this.setVitoria(v);
        this.setDerrota(d);
        this.setEmpate(e);

    }

    public void apresentar() {
        System.out.print("**************************");
        System.out.print("BEM VINDO AO UEC\n" +

                "LUTADOR:\n" +
                "Nome: " + this.getNome() +
                "\n Nacionalidade: " + this.getNacionalidade() +
                "\n Idade: " + this.getIdade() +
                "\n Altura: " + this.getAltura() +
                "\n Peso: " + this.getPeso() +
                "\n Categoria: " + this.getCategoria() +
                "\n Vitorias: " + this.getVitoria() +
                "\n Derrotas: " + this.getDerrota() +
                "\n Empates: " + this.getEmpate() + "\n");


        System.out.print("****************************");
    }
    public void status(){
        System.out.print("Nome: " +this.getNome() +
                "\n Categoria: " + this.getCategoria() +
                "\n Idade: " + this.getIdade() +
                "\n Vitorias: " + this.getVitoria() +
                "\n Derrotas: " + this.getDerrota() +
                "\n Empates: " + this.getEmpate());
    }
    public void ganharLuta(){
        this.setVitoria(this.getVitoria() + 1);
    }
    public void perderLuta(){
        this.setDerrota(this.getDerrota() + 1);
    }
    public void empatarLuta(){
        this.setEmpate(this.getEmpate() + 1);
    }
}
