import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginScreen() {
        setTitle("Login Screen");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
        layoutComponents();
        initializeListeners();
    }

    private void initializeComponents() {
        loginField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
    }

    private void layoutComponents() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Login:"));
        add(loginField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(registerButton);
    }

    private void initializeListeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginField.getText();
                String senha = new String(passwordField.getPassword());
                Arquivos arquivos = new Arquivos();
                if (arquivos.verificarLoginSenha(login, senha)) {
                    // Login bem-sucedido
                    System.out.println("Login bem-sucedido");
                } else {
                    // Usuário não encontrado
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado");
                }
            }
        });

        switchToRegistrationScreen();
    }

    private void switchToRegistrationScreen() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrationScreen registrationScreen = new RegistrationScreen();
                registrationScreen.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }
}