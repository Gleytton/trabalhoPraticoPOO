public class Operacao {

    public static int somar(int a, int b) {
        return a + b;
    }

    public static int subtrair(int a, int b) {

        return a - b;
    }

    public static int multiplicar(int a, int b) {

        return a * b;
    }

    public static int dividir(int a, int b){

        if (b != 0){

            return a/b;
        }
        else{

            System.out.println("ERRO! DIV 0!");
        }
    }
}
