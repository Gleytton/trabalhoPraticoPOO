import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationScreen extends JFrame {
    private JTextField nameField;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JRadioButton professorRadioButton;
    private JRadioButton studentRadioButton;
    private JButton submitButton;
    private JPanel painel1;
    private JPanel painel2;


    private void initializeComponents() {
        painel1 = new JPanel();
        painel1.setPreferredSize(new Dimension(400,600));
        painel1.setBounds(0,0,400,600);
        painel2 = new JPanel();
        painel2.setPreferredSize(new Dimension(200,600));
        painel2.setBounds(400,0,200,600);

        JLabel name = new JLabel("Nome:");
        name.setFont(new Font("Arial",Font.BOLD,18));
        name.setBounds(300,160,90,30);
        painel1.add(name);

        nameField = new JTextField(20);
        nameField.setBounds(270,75,300,40);
        nameField.setFont(new Font("Arial", Font.ITALIC,16));
        painel1.add(nameField);

        JLabel login = new JLabel("Login:");
        login.setFont(new Font("Arial",Font.BOLD,18));
        login.setBounds(200,160,90,30);
        painel1.add(login);

        loginField = new JTextField(20);
        loginField.setFont(new Font("Arial", Font.BOLD,18));
        loginField.setBounds(270,155,200,40);
        painel1.add(loginField);

        JLabel password = new JLabel("Senha:");
        password.setFont(new Font("Arial",Font.BOLD,18));
        password.setBounds(300,160,90,30);
        painel1.add(password);

        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.BOLD,18));
        passwordField.setBounds(270,185,200,40);
        painel1.add(passwordField);

        professorRadioButton = new JRadioButton("Professor");
        studentRadioButton = new JRadioButton("Estudante");
        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(professorRadioButton);
        roleGroup.add(studentRadioButton);
        painel2.add(professorRadioButton);
        painel2.add(studentRadioButton);
        submitButton = new JButton("Submit");
        painel2.add(submitButton);
    }
    public RegistrationScreen() {
        setTitle("Registre-se");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeComponents();
        initializeListeners();
        setLocationRelativeTo(null);

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