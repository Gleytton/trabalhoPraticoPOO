import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        int opcao = teclado.nextInt();
        switch (opcao){
            case(1):
                ArqAluno.Writer("testeAluno.txt","Gleyton", "gleyton","123");
                break;
                
            case(2):
                ArqAluno.Writer("testeProf.txt","joão","joão","456");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcao);
        }
    }

}