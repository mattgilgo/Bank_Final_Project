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
    private JButton mgrButton;
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
                String pass = userTextField.getText();
                userTextField.setText("");
                passTextField.setText("");
//                if (!bank.userLogin(user, pass)) {
//                    textShown.setText(String.format("Account not found! Please create account."));
//                }
            }
        });

        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userTextField.setText("");
                passTextField.setText("");
//                bank.createUserAccount(user, pass);
            }
        });
    }

    public static void main(String[] args) {
        LoginUI login = new LoginUI(new Bank());
    }
}
