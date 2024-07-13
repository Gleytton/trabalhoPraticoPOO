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
    private List<Pergunta> perguntas;
    private int currentQuestionIndex = 0;
    private Aluno aluno;

    public QuizScreen(Aluno aluno) {
        this.aluno = aluno;
        perguntas = new Arquivos().lerPerguntas();
        setupUI();
        setQuestion(currentQuestionIndex);
    }

    private void setupUI() {
        setTitle("Quiz");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        questionLabel = new JLabel();
        optionAButton = new JButton();
        optionBButton = new JButton();
        optionCButton = new JButton();
        optionDButton = new JButton();

        mainPanel.setLayout(new GridLayout(5, 1));
        mainPanel.add(questionLabel);
        mainPanel.add(optionAButton);
        mainPanel.add(optionBButton);
        mainPanel.add(optionCButton);
        mainPanel.add(optionDButton);

        add(mainPanel);

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
    }

    private void setQuestion(int questionIndex) {
        if (questionIndex < perguntas.size()) {
            Pergunta currentQuestion = perguntas.get(questionIndex);
            questionLabel.setText(currentQuestion.getPergunta());
            optionAButton.setText(currentQuestion.getOpcA());
            optionAButton.setActionCommand(currentQuestion.getOpcA());
            optionBButton.setText(currentQuestion.getOpcB());
            optionBButton.setActionCommand(currentQuestion.getOpcB());
            optionCButton.setText(currentQuestion.getOpcC());
            optionCButton.setActionCommand(currentQuestion.getOpcC());
            optionDButton.setText(currentQuestion.getOpcD());
            optionDButton.setActionCommand(currentQuestion.getOpcD());
        } else {
            JOptionPane.showMessageDialog(this, "Quiz concluído!");
            dispose(); // Fecha a janela do quiz
        }
    }

    private void checkAnswer(String selectedOption) {
        Pergunta currentQuestion = perguntas.get(currentQuestionIndex);
        aluno.setTotalRespondidas(aluno.getTotalRespondidas() + 1);
        if (selectedOption.equalsIgnoreCase(currentQuestion.getResposta())) {
            aluno.setAcertou(aluno.getAcertou() + 1);
            if (aluno.getAcertou() % 4 == 0) {
                aluno.setNivelAtual(aluno.getNivelAtual() + 1);
            }
            JOptionPane.showMessageDialog(this, "Resposta correta!");
        } else {
            JOptionPane.showMessageDialog(this, "Resposta incorreta!");
        }
        currentQuestionIndex++;
        setQuestion(currentQuestionIndex);
    }

    public static void main(String[] args) {

    }

}