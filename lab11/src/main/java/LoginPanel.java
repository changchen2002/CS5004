import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LoginPanel extends JFrame {
  public LoginPanel() {
    setTitle("Login Panel");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(350, 200);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

    JLabel userLabel = new JLabel("Username:");
    JTextField userField = new JTextField();

    JLabel passLabel = new JLabel("Password:");
    JPasswordField passField = new JPasswordField();

    JButton loginButton = new JButton("Login");

    panel.add(userLabel);
    panel.add(userField);
    panel.add(passLabel);
    panel.add(passField);
    panel.add(new JLabel());
    panel.add(loginButton);

    add(panel);

    loginButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String username = userField.getText();
        String password = new String(passField.getPassword());

        if (username.equals("admin") && password.equals("password123")) {
          JOptionPane.showMessageDialog(null, "Login successful!", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "Invalid username or password", "Error",
                                        JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    setVisible(true);
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run(){
        new LoginPanel();
      }
    });
  }
}
