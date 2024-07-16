import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class QuizScreen extends JFrame {
    private JPanel mainPanel;
    private JLabel questionLabel;
    private JButton optionAButton;
    private JButton optionBButton;
    private JButton optionCButton;
    private JButton optionDButton;
    private JLabel alunoNomeLabel;
    private JLabel alunoNivelLabel;
    private List<Pergunta> perguntas;
    private int currentQuestionIndex = 0;
    private Aluno aluno;
    private JLabel perguntasRestantesLabel;
    private JButton sairButton;

    public QuizScreen(Aluno aluno) {
        this.aluno = aluno;
        perguntas = new Arquivos().lerPerguntas();
        setupUI();
        setQuestion(currentQuestionIndex);
        setLocationRelativeTo(null);
    }

    private void setupUI() {
        setTitle("Quiz");
        setSize(800, 600); // Ajustado para acomodar mais conteúdo
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainPanel = new JPanel();
        questionLabel = new JLabel();
        optionAButton = new JButton();
        optionBButton = new JButton();
        optionCButton = new JButton();
        optionDButton = new JButton();
        sairButton = new JButton("Sair");
        alunoNomeLabel = new JLabel("Aluno: " + aluno.getNome());
        alunoNivelLabel = new JLabel("Nível: " + aluno.getNivelAtual());
        perguntasRestantesLabel = new JLabel();
        atualizarPerguntasRestantes(); // inicializar o texto do label

        mainPanel.setLayout(new GridLayout(9, 1)); // Garante que o layout possa acomodar todos os componentes
        mainPanel.add(alunoNomeLabel);
        mainPanel.add(alunoNivelLabel);
        mainPanel.add(perguntasRestantesLabel);
        mainPanel.add(questionLabel);
        mainPanel.add(optionAButton);
        mainPanel.add(optionBButton);
        mainPanel.add(optionCButton);
        mainPanel.add(optionDButton);
        mainPanel.add(sairButton); // Adiciona o sairButton ao painel

        add(mainPanel);

        // Configuração dos listeners dos botões
        ActionListener optionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer(e.getActionCommand());
            }
        };

        optionAButton.addActionListener(optionListener);
        optionBButton.addActionListener(optionListener);
        optionCButton.addActionListener(optionListener);
        optionDButton.addActionListener(optionListener);

        sairButton.addActionListener(e -> dispose()); // Listener para fechar a janela
    }

    private void setQuestion(int questionIndex) {
        if (questionIndex < perguntas.size()) {
            Pergunta currentQuestion = perguntas.get(questionIndex);
            questionLabel.setText(currentQuestion.getPergunta());
            optionAButton.setText(currentQuestion.getOpcA());
            optionAButton.setActionCommand("A");
            optionBButton.setText(currentQuestion.getOpcB());
            optionBButton.setActionCommand("B");
            optionCButton.setText(currentQuestion.getOpcC());
            optionCButton.setActionCommand("C");
            optionDButton.setText(currentQuestion.getOpcD());
            optionDButton.setActionCommand("D");
        } else {
            mostrarResumoEFinalizar();
        }
    }

    private void checkAnswer(String selectedOption) {
        Arquivos arquivos = new Arquivos();
        Pergunta currentQuestion = perguntas.get(currentQuestionIndex);
        if (selectedOption.equalsIgnoreCase(currentQuestion.getResposta())) {
            aluno.setAcertou(aluno.getAcertou() + 1);
            aluno.setTotalRespondidas(aluno.getTotalRespondidas() + 1);

            if (aluno.getAcertou() % 4 == 0) {
                aluno.setNivelAtual(aluno.getNivelAtual() + 1);
                alunoNivelLabel.setText("Nível: " + aluno.getNivelAtual()); // Atualiza o nível na interface
            }
            JOptionPane.showMessageDialog(this, "Resposta correta!");
        } else {
            aluno.setTotalRespondidas(aluno.getTotalRespondidas() + 1);
            JOptionPane.showMessageDialog(this, "Resposta incorreta!");
        }
        currentQuestionIndex++;
        setQuestion(currentQuestionIndex);
        atualizarPerguntasRestantes();
        arquivos.atualizarStatusAluno(aluno);
    }

    private void atualizarPerguntasRestantes() {
        int perguntasParaProximoNivel = 4 - (aluno.getAcertou() % 4);
        perguntasRestantesLabel.setText("Perguntas restantes para o próximo nível: " + perguntasParaProximoNivel);
    }

    private void mostrarResumoEFinalizar() {
        String mensagem = String.format("Resumo do Quiz:\nNível Atual: %d\nTotal de Perguntas Respondidas: %d\nTotal de Acertos: %d",
                aluno.getNivelAtual(), aluno.getTotalRespondidas(), aluno.getAcertou());
        JOptionPane.showMessageDialog(this, mensagem, "Resumo do Quiz", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Fecha a janela do quiz
    }

    public static void main(String[] args) {

    }

}