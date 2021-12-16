import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerUI extends JFrame {
    private JComboBox dropDown;
    private JLabel infoDisplay;
    private JLabel infoLabel;
    private JLabel accountLabel;
    private JPanel panel;
    private JButton transactionsButton;
    private JButton createAcctButton;


    public CustomerUI(String[] accounts) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(accounts);
        dropDown.setModel(model);
        dropDown.setForeground(new Color(0).BLACK);
        dropDown.setBackground(new Color(0).LIGHT_GRAY);
        setContentPane(panel);
        setTitle("Customer Account Portal");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        dropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO this is an example, but need to pull balance for that account
                infoDisplay.setText((String) dropDown.getSelectedItem());
            }
        });

        transactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO set off a table UI pass columns and data of all transactions
            }
        });
        createAcctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO go to create account function, open create account UI
            }
        });
    }

    public void showUI() {
        setVisible(true);
    }

    public static void main(String[] args) {
        String[] accounts = {"", "checking USD", "savings BTC"};
        CustomerUI custUI = new CustomerUI(accounts);
        custUI.showUI();
    }

}
