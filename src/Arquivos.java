import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivos {

    // Dentro da classe Arquivos
    public void salvarAluno(Aluno aluno) {
        File arquivo = new File("Aluno.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Formatação para salvar no arquivo
            String infoAluno = String.format("Nome: %s, Login: %s, Senha: %s, NivelAtual: %d, Acertou: %d, TotalRespondidas: %d",
                    aluno.getNome(), aluno.getLogin(), aluno.getSenha(), aluno.getNivelAtual(), aluno.getAcertou(), aluno.getTotalRespondidas());

            bw.write(infoAluno);
            bw.newLine();

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
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
        String caminho = "Aluno.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(", ");
                // Ajuste para considerar a remoção do atributo tipo
                if (dados.length >= 5) { // Verifica se há elementos suficientes
                    Aluno aluno = new Aluno(dados[0].split(": ")[1], // nome
                            dados[1].split(": ")[1], // login
                            dados[2].split(": ")[1]); // senha
                    // Configuração dos atributos adicionais
                    aluno.setNivelAtual(Integer.parseInt(dados[3].split(": ")[1]));
                    aluno.setAcertou(Integer.parseInt(dados[4].split(": ")[1]));
                    aluno.setTotalRespondidas(Integer.parseInt(dados[5].split(": ")[1]));
                    alunos.add(aluno);
                }
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
                // Supondo que o formato seja "Login: valor, Senha: valor, ..."
                String loginArquivo = dados[2].split(": ")[1];
                String senhaArquivo = dados[3].split(": ")[1];
                if (loginArquivo.equals(login) && senhaArquivo.equals(senha)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
