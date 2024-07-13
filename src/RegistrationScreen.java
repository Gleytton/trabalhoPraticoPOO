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

    public RegistrationScreen() {
        setTitle("Registration Screen");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initializeComponents();
        layoutComponents();
        initializeListeners();
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
                // Implement submission logic here
                System.out.println("Submit button clicked");
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