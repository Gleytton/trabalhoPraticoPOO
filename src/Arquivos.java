import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivos {


    public void salvarAluno(Aluno aluno) {
        List<Aluno> alunosExistentes = lerAlunos();
        for (Aluno alunoExistente : alunosExistentes) {
            if (alunoExistente.getNome().equals(aluno.getNome()) &&
                    alunoExistente.getLogin().equals(aluno.getLogin()) &&
                    alunoExistente.getSenha().equals(aluno.getSenha())) {
                System.out.println("Aluno já está cadastrado.");
                JOptionPane.showMessageDialog(null, "Aluno já cadastrado!");
                return;
            }
        }

        String caminhoArquivo = "Aluno.txt";
        File arquivo = new File(caminhoArquivo);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
                String conteudo = String.format("Nome: %s, Login: %s, Senha: %s, NivelAtual: %d, Acertou: %d, TotalRespondidas: %d\n",
                        aluno.getNome(), aluno.getLogin(), aluno.getSenha(), aluno.getNivelAtual(), aluno.getAcertou(), aluno.getTotalRespondidas());

                bw.write(conteudo);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao acessar o arquivo " + caminhoArquivo);
        }
        JOptionPane.showMessageDialog(null, "Aluno registrado com sucesso!");
    }

    // Método para salvar perguntas
    public void salvarPergunta(Pergunta pergunta) {
        if (perguntaJaExiste(pergunta.getPergunta())) {
            System.out.println("Pergunta já cadastrada!");
            return;
        }

        File arquivo = new File("Perguntas.txt");
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            try (FileWriter fw = new FileWriter(arquivo, true);
                 BufferedWriter bw = new BufferedWriter(fw)) {

                String infoPergunta = String.format("ID: %d, Nível: %d, Pergunta: %s, A: %s, B: %s, C: %s, D: %s, Resposta: %s\n",
                        pergunta.getIdPergunta(), pergunta.getNivel(), pergunta.getPergunta(), pergunta.getOpcA(), pergunta.getOpcB(), pergunta.getOpcC(), pergunta.getOpcD(), pergunta.getResposta());

                bw.write(infoPergunta);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao acessar o arquivo " + arquivo.getPath());
        }
    }

    // Método para ler informações dos alunos
    public List<Aluno> lerAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        String caminhoArquivo = "Aluno.txt"; // Considere usar um caminho absoluto aqui
        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists() || arquivo.length() == 0) {
            System.out.println("O arquivo não existe ou está vazio.");
            return alunos;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println("Linha lida: " + linha); // Imprime cada linha lida para depuração
                String[] dados = linha.split(", ");
                if (dados.length < 6) { // Verifica se todos os dados necessários estão presentes
                    System.out.println("Dados incompletos na linha: " + linha);
                    continue;
                }
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

    public void salvarProfessor(Professor professor) {
        if (professorJaExiste(professor.getLogin())) {
            JOptionPane.showMessageDialog(null, "Professor já cadastrado!");
            return;
        }

        String caminhoArquivo = "Professores.txt";
        File arquivo = new File(caminhoArquivo);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true))) {
                String conteudo = String.format("Nome: %s, Login: %s, Senha: %s\n",
                        professor.getNome(), professor.getLogin(), professor.getSenha());

                bw.write(conteudo);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar professor.");
        }
    }

    public List<Professor> lerProfessores() {
        List<Professor> professores = new ArrayList<>();
        String caminhoArquivo = "Professores.txt";
        File arquivo = new File(caminhoArquivo);

        if (!arquivo.exists()) {
            return professores;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(", ");
                if (dados.length < 3) {
                    continue;
                }
                String nome = dados[0].split(": ")[1];
                String login = dados[1].split(": ")[1];
                String senha = dados[2].split(": ")[1];

                Professor professor = new Professor(nome, login, senha);
                professores.add(professor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return professores;
    }

    public boolean professorJaExiste(String login) {
        List<Professor> professoresExistentes = lerProfessores();
        for (Professor professor : professoresExistentes) {
            if (professor.getLogin().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }

    public Professor buscarProfessor(String login) {
        File arquivo = new File("Professores.txt");
        if (!arquivo.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(", ");
                if (dados.length < 3) continue; // Verifica se a linha tem todos os dados necessários

                String nome = dados[0].split(": ")[1];
                String loginLido = dados[1].split(": ")[1];
                String senha = dados[2].split(": ")[1];

                if (loginLido.equalsIgnoreCase(login)) {
                    return new Professor(nome, loginLido, senha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // Retorna null se não encontrar o professor
    }

    public int getIdUltimaPergunta() {
        File arquivo = new File("Perguntas.txt");
        int ultimoId = 0; // Valor padrão se não houver perguntas

        if (!arquivo.exists()) {
            return ultimoId;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                // Supondo que o ID esteja no início da linha seguido de ":"
                // e que cada pergunta esteja em uma nova linha
                String[] partes = linha.split(", ");
                String idParte = partes[0]; // "ID: 123"
                String[] idSplit = idParte.split(": ");
                if (idSplit.length > 1) {
                    try {
                        ultimoId = Integer.parseInt(idSplit[1]);
                    } catch (NumberFormatException e) {
                        // Se não conseguir converter para inteiro, ignora e continua
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ultimoId;
    }
    public void atualizarStatusAluno(Aluno aluno) {
        File arquivo = new File("Aluno.txt");
        List<String> linhas = new ArrayList<>();
        String linhaAtualizada = "Nome: " + aluno.getNome() + ", Login: " + aluno.getLogin() + ", Senha: " + aluno.getSenha() + ", NivelAtual: " + aluno.getNivelAtual() + ", Acertou: " + aluno.getAcertou() + ", TotalRespondidas: " + aluno.getTotalRespondidas();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.contains("Login: " + aluno.getLogin())) {
                    linhas.add(linhaAtualizada);
                } else {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (String novaLinha : linhas) {
                pw.println(novaLinha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


