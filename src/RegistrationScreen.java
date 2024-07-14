import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationScreen extends JFrame {
    private JTextField nameField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JRadioButton professorRadioButton;
    private JRadioButton studentRadioButton;
    private JButton submitButton;

    public RegistrationScreen() {
        setTitle("Registration Screen");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeComponents();
        layoutComponents();
        initializeListeners();
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        nameField = new JTextField(20);
        loginField = new JTextField(20);
        passwordField = new JPasswordField(20);
        professorRadioButton = new JRadioButton("Professor");
        studentRadioButton = new JRadioButton("Student");
        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(professorRadioButton);
        roleGroup.add(studentRadioButton);
        submitButton = new JButton("Submit");
    }

    private void layoutComponents() {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Login:"));
        add(loginField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(professorRadioButton);
        add(studentRadioButton);
        add(submitButton);
    }

    private void initializeListeners() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                String login = loginField.getText();
                String senha = new String(passwordField.getPassword());
                System.out.println(nome + login + senha);

                Arquivos arquivos = new Arquivos(); // Create an instance of Arquivos

                if (studentRadioButton.isSelected()) {
                    Aluno aluno = new Aluno(nome, login, senha, 1, 0, 0);
                    arquivos.salvarAluno(aluno);
                    dispose();
                    LoginScreen loginScreen = new LoginScreen();
                    loginScreen.setVisible(true);
                } else if (professorRadioButton.isSelected()) {
                    Professor professor = new Professor(nome, login, senha);
                    arquivos.salvarProfessor(professor);
                    JOptionPane.showMessageDialog(null, "Professor registrado com sucesso!");
                    dispose();
                    LoginScreen loginScreen = new LoginScreen();
                    loginScreen.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegistrationScreen().setVisible(true);
            }
        });
    }
}