import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        ControleRemoto r1 = new ControleRemoto(0,false, false);
        r1.ligar();
        r1.abrirMenu();
        r1.fecharMenu();
        r1.maisVolume();
        r1.abrirMenu();
        r1.fecharMenu();
    }
}