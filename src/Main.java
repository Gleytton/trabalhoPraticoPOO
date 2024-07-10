import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Aluno> alunos = Arquivos.lerInformacoesAlunos();
        List<Pergunta> perguntas = Arquivos.lerPerguntas();
    }
}
