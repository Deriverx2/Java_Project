import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    private JLabel usernameLabel, passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, cancelButton;

    public Login() {
        super("Login");

        setLayout(null);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(40, 20, 100, 30);
        add(usernameLabel);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40, 70, 100, 30);
        add(passwordLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 20, 150, 30);
        add(usernameField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 70, 150, 30);
        add(passwordField);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image image = icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(350, 10, 150, 150);
        add(imageLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton = new JButton("Login");
        loginButton.setBounds(40, 140, 120, 30);
        loginButton.setFont(new Font("serif", Font.BOLD, 15));
        loginButton.addActionListener(this);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        add(loginButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 140, 120, 30);
        cancelButton.setFont(new Font("serif", Font.BOLD, 15));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        add(cancelButton);
        cancelButton.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(600, 300);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginButton) {
            try {
                Conn connection = new Conn();
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                String query = "select * from login where username='" + username + "' and password='" + password + "'";
                ResultSet rs = connection.s.executeQuery(query);

                if (rs.next()) {
                    new Dashboard().setVisible(true);
                    dispose(); // Close the login window
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid login");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancelButton) {
            System.exit(0);
        }
    }

    public static void main(String[] arg) {
        SwingUtilities.invokeLater(() -> {
            new Login();
        });
    }
}
