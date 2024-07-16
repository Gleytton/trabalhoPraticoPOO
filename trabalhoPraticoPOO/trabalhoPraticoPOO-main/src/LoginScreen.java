import javax.swing.*;
import java.awt.*;
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
        registerButton = new JButton("Registrar");

        JLabel logo = new JLabel("Clever English");
        logo.setBounds(250, 100, 340, 120);
        logo.setFont(new Font("Courier New",Font.BOLD, 40));
        add(logo);
        JLabel login = new JLabel("Login:");
        login.setFont(new Font("Arial", Font.BOLD,18));
        login.setBounds(300,200,90,120);
        add(login);
        JTextField loginField = new JTextField(20);
        loginField.setBounds(360,240,150,40);
        loginField.setFont(new Font("Arial",Font.ITALIC,16));
        add(loginField);

        JLabel password =new JLabel("Senha:");
        password.setFont(new Font("Arial",Font.BOLD,18));
        password.setBounds(300, 280,90,120);
        add(password);
        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(365,320,150,40);
        passwordField.setFont(new Font("Arial",Font.ITALIC,16));
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setFont( new Font("Arial", Font.BOLD,20));
        loginButton.setBounds(390,400,100,25);
        loginButton.setBackground(new Color(128,128,128));
        loginButton.setForeground(new Color(248,248,255));
        add(loginButton);

        JLabel registerText = new JLabel("Conheça nosso trabalho!");
        registerText.setFont( new Font("Roboto",Font.BOLD,16));
        registerText.setBounds(10,440,240,60);
        add(registerText);

        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("Arial",Font.BOLD,16));
        registerButton.setBounds(370,465,120,25);
        registerButton.setBackground(new Color(128,128,128));
        registerButton.setForeground(new Color(248,248,255));
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String password = new String(passwordField.getPassword());
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