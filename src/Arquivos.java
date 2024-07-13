import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivos {

    // Dentro da classe Arquivos
    public static void salvarAluno(Aluno aluno) {
        String nome = aluno.getNome();
        String login = aluno.getLogin();
        String senha = aluno.getSenha();
        int nivelAtual = aluno.getNivelAtual();
        int acertou = aluno.getAcertou();
        int totalRespondidas = aluno.getTotalRespondidas();
        String caminhoArquivo = "C:\\Users\\lugav\\IdeaProjects\\trabalhoPraticoPOO\\Aluno.txt"; // Pode ser ajustado para um caminho absoluto se necessário
        File arquivo = new File(caminhoArquivo);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile(); // Cria o arquivo se ele não existir
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
                String conteudo = String.format("Nome: %s, Login: %s, Senha: %s, NivelAtual: %d, Acertou: %d, TotalRespondidas: %d\n",
                        nome, login, senha, nivelAtual, acertou, totalRespondidas);

                System.out.println("Salvando no arquivo Aluno.txt: " + conteudo);

                bw.write(conteudo);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao acessar o arquivo " + caminhoArquivo);
        }
    }

    // Método para salvar perguntas
    public void salvarPergunta(Pergunta pergunta) {
        File arquivo = new File("Perguntas.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Formatação da pergunta para salvar no arquivo
            String infoPergunta = String.format("ID: %d, Nível: %d, Pergunta: %s, A: %s, B: %s, C: %s, D: %s, Resposta: %s",
                    pergunta.getIdPergunta(), pergunta.getNivel(), pergunta.getPergunta(), pergunta.getOpcA(), pergunta.getOpcB(), pergunta.getOpcC(), pergunta.getOpcD(), pergunta.getResposta());

            bw.write(infoPergunta);
            bw.newLine();

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para ler informações dos alunos
    public List<Aluno> lerAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        File arquivo = new File("Aluno.txt");
        if (!arquivo.exists()) {
            return alunos;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(", ");

                String nome = dados[0].split(": ")[1];
                String login = dados[1].split(": ")[1];
                String senha = dados[2].split(": ")[1];
                int nivelAtual = Integer.parseInt(dados[3].split(": ")[1]);
                int acertou = Integer.parseInt(dados[4].split(": ")[1]);
                int totalRespondidas = Integer.parseInt(dados[5].split(": ")[1]);

                Aluno aluno = new Aluno(nome, login, senha, nivelAtual, acertou, totalRespondidas);
                alunos.add(aluno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    // Método para ler perguntas
    public List<Pergunta> lerPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();
        String caminho = "Perguntas.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(", ");
                Pergunta perguntaExistentes = new Pergunta(Integer.parseInt(dados[1].split(": ")[1]),
                        dados[2].split(": ")[1],
                        dados[3].split(": ")[1],
                        dados[4].split(": ")[1],
                        dados[5].split(": ")[1],
                        dados[6].split(": ")[1],
                        dados[7].split(": ")[1]);
                perguntas.add(perguntaExistentes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return perguntas;
    }

    // Método para verificar se a pergunta já existe
    public boolean perguntaJaExiste(String novaPergunta) {
        List<Pergunta> perguntasExistentes = lerPerguntas();
        for (Pergunta pergunta : perguntasExistentes) {
            if (pergunta.getPergunta().equalsIgnoreCase(novaPergunta)) {
                return true;
            }
        }
        return false;
    }

    // Método para verificar se o usuario já está cadastrado
    public boolean alunoJaExiste(String login) {
        List<Aluno> alunosExistentes = lerAlunos();
        for (Aluno aluno : alunosExistentes) {
            if (aluno.getLogin().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarLoginSenha(String login, String senha) {
        File arquivo = new File("Aluno.txt");
        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] dados = linha.split(", ");
                // Ajuste para garantir que estamos acessando os índices corretos
                if (dados.length > 2) { // Garante que há dados suficientes na linha
                    String loginArquivo = dados[1].split(": ")[1].trim(); // Adiciona trim() para remover espaços extras
                    String senhaArquivo = dados[2].split(": ")[1].trim(); // Adiciona trim() para remover espaços extras
                    if (loginArquivo.equals(login) && senhaArquivo.equals(senha)) {
                        return true;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Aluno buscarAluno(String loginProcurado) {
        File arquivo = new File("Aluno.txt");
        if (!arquivo.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] atributos = linha.split(", "); // Supondo que os atributos são separados por vírgula e espaço
                String login = atributos[1].split(": ")[1]; // Supondo que o login é o segundo atributo e está no formato "Login: valor"
                if (login.equals(loginProcurado)) {
                    // Supondo que os atributos estão na ordem: Nome, Login, Senha, NivelAtual, Acertou, TotalRespondidas
                    String nome = atributos[0].split(": ")[1];
                    String senha = atributos[2].split(": ")[1];
                    int nivelAtual = Integer.parseInt(atributos[3].split(": ")[1]);
                    int acertou = Integer.parseInt(atributos[4].split(": ")[1]);
                    int totalRespondidas = Integer.parseInt(atributos[5].split(": ")[1]);
                    return new Aluno(nome, login, senha, nivelAtual, acertou, totalRespondidas);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
