import java.util.List;

public class Main {
    public static void main(String[] args) {
        Arquivos arquivos = new Arquivos();

        // Passo 2: Criar novos objetos para teste
        Aluno novoAluno = new Aluno("lugavit", "loygcas", "11981");
        arquivos.salvarAluno(novoAluno);
        Pergunta novaPergunta = new Pergunta(1, "Nova Pergunta?", "A", "B", "C", "D", "A");
        arquivos.salvarPergunta(novaPergunta);

        // Passo 4: Salvar novas informações
        arquivos.salvarPergunta(novaPergunta);
        System.out.println("Nova pergunta salva com sucesso.");

        arquivos.salvarAluno(novoAluno);
        System.out.println("Novo aluno salvo com sucesso.");


        // Passo 1: Ler informações existentes
        List<Aluno> alunos = arquivos.lerAlunos();
        System.out.println("Alunos lidos do arquivo:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        List<Pergunta> perguntas = arquivos.lerPerguntas();
        System.out.println("\nPerguntas lidas do arquivo:");
        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta);
        }

    }
}