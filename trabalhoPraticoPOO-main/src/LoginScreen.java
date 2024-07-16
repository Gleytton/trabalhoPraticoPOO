import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JPanel mainPanel;

    public LoginScreen() {
        setTitle("Login");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildUI();
        setLocationRelativeTo(null);
    }

    private void buildUI() {
        mainPanel = new JPanel();
        loginField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Registrar");

        mainPanel.add(new JLabel("Login:"));
        mainPanel.add(loginField);
        mainPanel.add(new JLabel("Senha:"));
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField.getPassword());
                Arquivos arquivos = new Arquivos();


                Aluno alunoLogado = arquivos.buscarAluno(login);
                    if (alunoLogado != null) {
                        QuizScreen quizScreen = new QuizScreen(alunoLogado);
                        quizScreen.setVisible(true);
                        dispose(); // Fecha a tela de login
                    } else {
                        Professor professorLogado = arquivos.buscarProfessor(login);
                        if (professorLogado != null) {
                            ProfessorScreen professorScreen = new ProfessorScreen(professorLogado.getNome());
                            professorScreen.setVisible(true);
                            dispose(); // Fecha a tela de login
                        } else {
                            JOptionPane.showMessageDialog(null, "Login ou senha inválidos.");
                        }
                    }

            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationScreen registrationScreen = new RegistrationScreen();
                registrationScreen.setVisible(true);
                dispose(); // Fecha a tela de login
            }
        });

        add(mainPanel);
    }

    public static void main(String[] args) {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
    }
}