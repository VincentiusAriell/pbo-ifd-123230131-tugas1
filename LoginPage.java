package tugassatu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener {
    private final JTextField username;
    private final JPasswordField pass;
    private final JButton loginButton;

    public LoginPage() {
        setTitle("Halaman Login");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        add(userLabel);

        username = new JTextField();
        username.setBounds(100, 20, 150, 25);
        add(username);

        JLabel password = new JLabel("Password:");
        password.setBounds(20, 50, 80, 25);
        add(password);

        pass = new JPasswordField();
        pass.setBounds(100, 50, 150, 25);
        add(pass);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 100, 25);
        loginButton.addActionListener(this);
        add(loginButton);

        setVisible(true);
    }

    public void cek() {
        String usnInput = username.getText().toLowerCase();
        String passInput = new String(pass.getPassword()).toLowerCase();

        if (usnInput.equals("pbo") && passInput.equals("if-d")) {
            new HomePage();
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username atau Password salah", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            cek();
        }
    }
}
