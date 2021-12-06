import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_GUI implements ActionListener{
    
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel pwrdLabel;
    private static JPasswordField pwrdText;
    private static JButton button;
    private static JLabel sucJLabel;

    public static void main(String[] arg) {

    panel = new JPanel();
    frame = new JFrame();
    frame.setSize(100,100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.add(panel);

    panel.setLayout(null);

    userLabel = new JLabel("User");
    userLabel.setBounds(10,20,80,25);
    panel.add(userLabel);

    userText = new JTextField();
    userText.setBounds(100, 20, 165, 25);
    panel.add(userText);

    pwrdLabel = new JLabel("Password");
    pwrdLabel.setBounds(10,50,80,25);
    panel.add(pwrdLabel);

    pwrdText = new JPasswordField();
    pwrdText.setBounds(100, 50, 165, 25);
    panel.add(pwrdText);

    button = new JButton("Login");
    button.setBounds(10, 80, 80, 25);
    button.addActionListener(new Login_GUI());
    panel.add(button);

    sucJLabel = new JLabel("");
    sucJLabel.setBounds(10, 110, 300, 25);
    
    panel.add(sucJLabel);

    frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        String user = userText.getText();
        String password = pwrdText.getText();
        //System.out.println(user + ", " + password);

        if (user.equals("Matt") && password.equals("yeet")) {
            sucJLabel.setText("");
            sucJLabel.setText("Login successful!");
        } else {
            sucJLabel.setText("");
            sucJLabel.setText("Invalid login. Please try again.");
        }
    }

}