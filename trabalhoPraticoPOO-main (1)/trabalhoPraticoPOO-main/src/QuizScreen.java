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
                JButton clickedButton = (JButton) e.getSource();
                String buttonText = clickedButton.getText();
                String selectedOption = buttonText.substring(0, 1); // Pega apenas a letra da opção (A, B, C, D)
                checkAnswer(selectedOption);
            }
        };

        optionAButton.addActionListener(optionListener);
        optionBButton.addActionListener(optionListener);
        optionCButton.addActionListener(optionListener);
        optionDButton.addActionListener(optionListener);

        sairButton.addActionListener(e -> mostrarResumoEFinalizar());
    }

    private void setQuestion(int questionIndex) {

        if (questionIndex < perguntas.size()) {
            Pergunta currentQuestion = perguntas.get(questionIndex);

            if (currentQuestion.getNivel() <= aluno.getNivelAtual()) {
                questionLabel.setText(currentQuestion.getPergunta());
                optionAButton.setText("A) " + currentQuestion.getOpcA());
                optionBButton.setText("B) " + currentQuestion.getOpcB());
                optionCButton.setText("C) " + currentQuestion.getOpcC());
                optionDButton.setText("D) " + currentQuestion.getOpcD());
                atualizarPerguntasRestantes();
            } else {
                mostrarResumoEFinalizar();
            }
        } else {
            mostrarResumoEFinalizar();
        }
    }


    private void checkAnswer(String selectedOption) {
        Arquivos arquivos = new Arquivos();
        Pergunta currentQuestion = perguntas.get(currentQuestionIndex);
        boolean isCorrect = selectedOption.equalsIgnoreCase(currentQuestion.getResposta());
        if (isCorrect) {
            aluno.setAcertou(aluno.getAcertou() + 1);
            aluno.adicionarPerguntaRespondidaCorretamente(currentQuestion.getIdPergunta());
        }
        aluno.setTotalRespondidas(aluno.getTotalRespondidas() + 1);

        if (aluno.getAcertou() % 4 == 0 && isCorrect) {
            aluno.setNivelAtual(aluno.getNivelAtual() + 1);
            alunoNivelLabel.setText("Nível: " + aluno.getNivelAtual());
            mostrarResumo(); // Chama o método para mostrar o resumo sem finalizar
        }

        JOptionPane.showMessageDialog(this, isCorrect ? "Resposta correta!" : "Resposta incorreta!");


        currentQuestionIndex++;

        if (currentQuestionIndex < perguntas.size()) {
            setQuestion(currentQuestionIndex);
        } else {
            mostrarResumoEFinalizar(); // Este método será chamado apenas se todas as perguntas forem respondidas
        }
        atualizarPerguntasRestantes();
        arquivos.atualizarStatusAluno(aluno);
    }


    private void atualizarPerguntasRestantes() {
        int perguntasParaProximoNivel = 4 - (aluno.getAcertou() % 4);
        perguntasRestantesLabel.setText("Perguntas restantes para o próximo nível: " + perguntasParaProximoNivel);
    }

    private void mostrarResumoEFinalizar() {
        mostrarResumo(); // Reutiliza o método mostrarResumo
        dispose(); // Fecha a janela
    }

    private void mostrarResumo() {
        String mensagemResumo = String.format("Resumo do Quiz:\nTotal de Perguntas Respondidas: %d\nTotal de Acertos: %d\nNível Atual: %d",
                aluno.getTotalRespondidas(), aluno.getAcertou(), aluno.getNivelAtual());
        JOptionPane.showMessageDialog(this, mensagemResumo, "Resumo do Quiz", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

    }

}