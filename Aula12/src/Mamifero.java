public class Mamifero extends Animal{
    private String corPelo;

    public String getCorPelo(){
        return this.corPelo;
    }
    public void setCorPelo(String corPelo){
        this.corPelo = corPelo;
    }
    @Override
    public void locomover(){
        System.out.print("CORRENDO!!!");
    }
    @Override
    public void alimentar( ){
        System.out.print("MAMANDO!!!");
    }
    @Override
    public void emitirSom(){
        System.out.print("Som de mamifero");
    }
}
