import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame{
    private JPanel mainPanel;
    private JTextField userTextField;
    private JPasswordField passTextField;
    private JButton loginButton;
    private JButton createAccount;
    private JLabel userName;
    private JLabel password;
    private JLabel textShown;
    private JButton createMgrButton;
    private Bank bank;

    public LoginUI(Bank bank) {
        this.bank = bank;
        setContentPane(mainPanel);
        setTitle("Welcome");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userTextField.getText();
                String pass = String.valueOf(passTextField.getPassword());
                if (bank.userLogin(user, pass)) {
                    textShown.setText(String.format("Login Successful! Welcome, %s!", user));
                } else {
                    textShown.setText(String.format("Invalid User, %s does not exist!", user));
                }
            }
        });

        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userTextField.getText();
                String pass = String.valueOf(passTextField.getPassword());
                // TODO create user account
            }
        });
        createMgrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userTextField.getText();
                String pass = String.valueOf(passTextField.getPassword());
                // TODO create manager account
            }
        });
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        LoginUI login = new LoginUI(bank);
    }
}
