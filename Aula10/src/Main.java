//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Aluno p2 = new Aluno("Maria",0,"F","0","Informatica");
        Professor p3 = new Professor("Claudio",0,"M",null,2500.75F);
        Funcionario p4 = new Funcionario("Fabiana", 0,"F","Estoque",true);

        System.out.print(p2.toString());
    }
}