public class Quadrado implements AreaCalculavel{

    private double lado;
// construtor
    public Quadrado(double l){
        this.lado = l;
    }
// getter e setters

    public double getLado(){
        return this.lado;
    }
    public void setLado(double l){
        this.lado = l;
    }

    public double calculaArea(){
        return this.getLado()*this.getLado();
    }

}
