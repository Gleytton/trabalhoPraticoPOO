public class Reptil extends Animal{
    private String corEscama;

    public String getCorEscama(){
        return this.corEscama;
    }
    public void setCorEscama(String corEscama){
        this.corEscama = corEscama;
    }

    @Override
    public void locomover(){
        System.out.print("RASTEJANDO!!!");
    }
    @Override
    public void alimentar(){
        System.out.print("VEGETAIS");
    }
    @Override
    public void emitirSom(){
        System.out.print("Som de reptil");
    }
}
