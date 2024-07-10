import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    public void salvarInformacoesAluno(Aluno aluno) {
        File arquivo = new File("Aluno.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Formatação das informações do aluno para salvar no arquivo
            String infoAluno = String.format("Login: %s, Senha: %s, Acertos: %d, Respondidas: %d, Nível: %d",
                    aluno.getLogin(), aluno.getSenha(), aluno.getAcertou(), aluno.getTotalRespondidas(), aluno.getNivelAtual());

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
    public static List<Aluno> lerInformacoesAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String caminho = "Aluno.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(", ");
                // Supondo que o ID seja o primeiro elemento, e os dados de interesse comecem do segundo elemento
                Aluno aluno = new Aluno(dados[1].split(": ")[1], // nome
                        dados[2].split(": ")[1], // login
                        dados[3].split(": ")[1], // senha
                        dados[4].split(": ")[1], // tipo
                        Integer.parseInt(dados[5].split(": ")[1]), // nivelAtual
                        Integer.parseInt(dados[6].split(": ")[1]), // acertou
                        Integer.parseInt(dados[7].split(": ")[1])); // totalRespondidas
                alunos.add(aluno);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    // Método para ler perguntas
    public static List<Pergunta> lerPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();
        String caminho = "Perguntas.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(", ");
                Pergunta perguntaExistentes = new Pergunta(Integer.parseInt(dados[1].split(": ")[1]), dados[2].split(": ")[1], dados[3].split(": ")[1], dados[4].split(": ")[1], dados[5].split(": ")[1], dados[6].split(": ")[1], dados[7].split(": ")[1]);
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

}
