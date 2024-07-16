public class Main {

    public static void main(String[] args){
        Lutador[] l   = new Lutador[6];

        l[0] = new Lutador("Pretty Boy","França",31, 1.75F, 68.9F, 11,2,1 );
        l[1] = new Lutador("Putscript", "Brasil", 29, 1.68F,57.8F,14,2,3);
        l[2] = new Lutador("Snapshadow", "EUA", 35,1.65F,80.9F,12,2,1);
        l[3] = new Lutador("Deadcode", "Australia", 28, 1.93F, 81.6F,13,0,2);
        l[4] = new Lutador("Ufocobol","Brasil", 37,1.70F,119.3F, 5,4,3);
        l[5]= new Lutador("Nerdard", "EUA",30,1.81F, 105.7F,12,2,4);

        Luta luta = new Luta();
        luta.marcarLuta(l[0],l[1]);
        luta.lutar();





    }
}
