import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {
    private JLabel title;
    private JButton nextButton;

    public HotelManagementSystem() {
        setTitle("Hotel Management System");
        setSize(1366, 430);
        setLocationRelativeTo(null); // Center the window on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image scaledImage = backgroundImage.getImage().getScaledInstance(1366, 390, Image.SCALE_DEFAULT);
        backgroundImage = new ImageIcon(scaledImage);

        title = new JLabel("HOTEL MANAGEMENT SYSTEM");
        title.setBounds(30, 300, 1500, 100);
        title.setFont(new Font("serif", Font.PLAIN, 70));
        title.setForeground(Color.RED);

        nextButton = new JButton("Next");
        nextButton.setBounds(1170, 325, 150, 50);
        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);
        nextButton.addActionListener(this);

        // Create a JPanel for the background image
        ImageIcon finalBackgroundImage = backgroundImage;
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(finalBackgroundImage.getImage(), 0, 0, null);
            }
        };

        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0, 0, 1366, 390);
        backgroundPanel.add(title);
        backgroundPanel.add(nextButton);

        add(backgroundPanel);
        setVisible(true);

        // Replace the flashing label with a timer (optional)
        Timer timer = new Timer(1000, e -> title.setVisible(!title.isVisible()));
        timer.start();
    }

    public void actionPerformed(ActionEvent ae) {
        new Login().setVisible(true);
        dispose(); // Close the current window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HotelManagementSystem();
        });
    }
}
