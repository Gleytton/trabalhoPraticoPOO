public class Peixe extends Animal{
    private String corEscama;

    public String getCorEscama(){
        return this.corEscama;
    }
    public void setCorEscama(String corEscama){
        this.corEscama = corEscama;
    }
    @Override
    public void locomover(){
        System.out.print("NADANDO!!!");
    }
    @Override
    public void alimentar(){
        System.out.print("COMENDO ALGAS");
    }
    @Override
    public void emitirSom(){
        System.out.print("Peixe não tem som");
    }

    public void soltouBolha(){
        System.out.print("Soltou uma bolha");
    }

}
