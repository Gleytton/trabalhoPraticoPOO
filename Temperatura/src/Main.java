import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        float temperaturaCelsius, temperaturaFahrenheit, temperaturaKelvin;
        float temperaturaReaumur, temperaturaRankine;

        temperaturaCelsius = 0;

        System.out.println("Digite uma tempetura (°C):");
        temperaturaCelsius = teclado.nextFloat();

        temperaturaKelvin = (float)(temperaturaCelsius + 273);
        temperaturaFahrenheit = (float) (temperaturaCelsius*1.8+ 32);
        temperaturaReaumur = (float)(temperaturaCelsius*0.8);
        temperaturaRankine = (float)((temperaturaCelsius*1.8+ 32) + 459.67);


        System.out.println("Temperatura " + temperaturaCelsius + "em Kelvin:" + temperaturaKelvin);
        System.out.println("Temperatura " + temperaturaCelsius + "em Fahrenheit:" + temperaturaFahrenheit);
        System.out.println("Temperatura " + temperaturaCelsius + "em Reaumur:" + temperaturaReaumur);
        System.out.println("Temperatura " + temperaturaCelsius + "em Rankine:" + temperaturaRankine);


    }
    }