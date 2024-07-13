import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorScreen extends JFrame {
    private JLabel professorNameLabel;
    private JTextField questionField;
    private JTextField[] optionFields = new JTextField[4];
    private JComboBox<String> correctAnswerComboBox;
    private JButton submitButton;
    private JComboBox<String> levelComboBox;

    public ProfessorScreen(String professorName) {
        setTitle("Área do Professor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        levelComboBox = new JComboBox<>(new String[]{"1", "2", "3", "4"});
        add(new JLabel("Nível da Pergunta:"));
        add(levelComboBox);

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
                // Criação da instância de Pergunta
                Pergunta pergunta = new Pergunta(Integer.parseInt((String) levelComboBox.getSelectedItem()), questionField.getText(),
                        optionFields[0].getText(), optionFields[1].getText(), optionFields[2].getText(), optionFields[3].getText(),
                        (String) correctAnswerComboBox.getSelectedItem());

                // Ajuste conforme necessário para obter o ID correto
                pergunta.setIdPergunta(Pergunta.getIdPergunta() + 1);

                // Salvando a pergunta
                Arquivos arquivos = new Arquivos();
                arquivos.salvarPergunta(pergunta);

                // Dentro do actionPerformed do submitButton após salvar a pergunta
                int resposta = JOptionPane.showOptionDialog(null, "Pergunta cadastrada com sucesso! Deseja cadastrar outra pergunta?", "Pergunta Cadastrada", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Cadastrar Outra", "Sair"}, JOptionPane.YES_OPTION);

                if (resposta == JOptionPane.YES_OPTION) {
                    // Limpar todos os campos
                    questionField.setText("");
                    for (JTextField field : optionFields) {
                        field.setText("");
                    }
                    correctAnswerComboBox.setSelectedIndex(0);
                    levelComboBox.setSelectedIndex(0);
                } else {
                    // Fechar a tela do professor e abrir a tela de login
                    dispose();
                    LoginScreen loginScreen = new LoginScreen();
                    loginScreen.setVisible(true);
                }
            }
        });
    }
}