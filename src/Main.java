import java.util.List;

public class Main {

    public static void main(String[] args) {
        Arquivos arquivos = new Arquivos();
        arquivos.lerAlunos();
        arquivos.lerPerguntas();
        Aluno novoAluno = new Aluno("lucass", "loga", "123", 1, 0, 0);
        arquivos.salvarAluno(novoAluno);


    }
}