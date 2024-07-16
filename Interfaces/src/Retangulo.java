public class Retangulo implements AreaCalculavel{

    private double altura;
    private double base;

    // construtor

    public Retangulo(double a, double b){
        this.altura = a;
        this.base = b;
    }

    // getters e setters
    public double getAltura(){
        return this.altura;
    }
    public void setAltura(double a){
        this.altura = a;
    }
    public double getBase(){
        return this.base;
    }
    public void setBase(double b){
        this.base = b;
    }
    // encapsulados
     public double calculaArea(){
        return this.getBase()*this.getAltura();
     }

}
