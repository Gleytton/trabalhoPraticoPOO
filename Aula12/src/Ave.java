public class Ave extends Animal{
    private String corPena;

    public String getcorPena(){
        return this.corPena;
    }
    public void setCorPena(String corPena){
        this.corPena = corPena;
    }
    @Override
    public void locomover(){
        System.out.print("VOANDO!!!");
    }
    @Override
    public void alimentar(){
        System.out.print("FRUTAS E VERMES");
    }
    @Override
    public void emitirSom(){
        System.out.print("Som de aves");
    }
    public void fazerNinho(){
        System.out.print("Fazendo ninho!!!");
    }
}
