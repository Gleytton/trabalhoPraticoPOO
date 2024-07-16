public class Circulo implements AreaCalculavel{

    private double raio;

    //construtor

    public Circulo(double r){
        this.raio = r;
    }
    // getter e setter
    public double getRaio(){
        return this.raio;
    }
    public void setRaio(double r){
        this.raio = r;
    }
    // calculaArea
    public double calculaArea(){
        return 3.14*this.raio*this.raio;
    }

}
