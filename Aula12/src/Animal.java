public abstract class Animal {
    private float peso;
    private int idade, membros;

    public float getPeso(){
        return this.peso;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }
    public abstract void locomover();
    public abstract void alimentar();
    public abstract void emitirSom();

}
