import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorScreen extends JFrame {
    private JLabel professorNameLabel;
    private JTextField questionField;
    private JTextField[] optionFields = new JTextField[4];
    private JComboBox<String> correctAnswerComboBox;
    private JButton submitButton;

    public ProfessorScreen(String professorName) {
        setTitle("Área do Professor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        professorNameLabel = new JLabel("Professor: " + professorName);
        questionField = new JTextField(20);
        for (int i = 0; i < optionFields.length; i++) {
            optionFields[i] = new JTextField(20);
        }
        correctAnswerComboBox = new JComboBox<>(new String[]{"A", "B", "C", "D"});
        submitButton = new JButton("Cadastrar Pergunta");

        add(professorNameLabel);
        add(new JLabel("Pergunta:"));
        add(questionField);
        for (int i = 0; i < optionFields.length; i++) {
            add(new JLabel("Opção " + (char)('A' + i) + ":"));
            add(optionFields[i]);
        }
        add(new JLabel("Resposta Correta:"));
        add(correctAnswerComboBox);
        add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implemente a lógica para salvar a pergunta e as opções aqui
                JOptionPane.showMessageDialog(null, "Pergunta cadastrada com sucesso!");
            }
        });
    }
}