import java.util.List;

public class Main {

    public static void main(String[] args) {
        Arquivos arquivos = new Arquivos();

        // Passo 2: Criar novos objetos para teste
        Aluno novoAluno = new Aluno("lugavit", "loygcas", "11981",1,0,0);
        Arquivos.salvarAluno(novoAluno);
        System.out.println(novoAluno);
        Pergunta novaPergunta = new Pergunta(1, "Nova Pergunta?", "A", "B", "C", "D", "A");
        arquivos.salvarPergunta(novaPergunta);

    }
}