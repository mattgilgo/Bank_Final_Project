import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerUI extends JFrame {
    private JButton seeUserTransactionsButton;
    private JPanel panel;
    private JButton seeAllTransactionsButton;
    private JComboBox userDrop;
    private JButton seeAllStockHoldingsButton;
    private JLabel bankBalanceText;
    private JButton seeUserStocksButton;

    private ATM atm;

    public ManagerUI(ATM atm) {
        this.atm = atm;

        // TODO set bank balance to appropriate value
        bankBalanceText.setText("$");

        // TODO implement method to get all users
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(atm.getStringListOfAllUsers());
        userDrop.setModel(model);
        userDrop.setForeground(new Color(0).BLACK);
        userDrop.setBackground(new Color(0).LIGHT_GRAY);
        setContentPane(panel);

        setTitle("Manager Account Portal");
        setSize(450, 300);

        seeUserTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int account_id = (Integer.parseInt(((String) userDrop.getSelectedItem()).replaceAll("[\\D]", "")));
                // TODO get transactions for this user
            }
        });
        seeUserStocksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int account_id = (Integer.parseInt(((String) userDrop.getSelectedItem()).replaceAll("[\\D]", "")));
                // TODO get stocks for this user
            }
        });
        seeAllTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO get all user transactions
            }
        });
        seeAllStockHoldingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO get all user stocks
            }
        });
    }

    public void showUI() {
        setVisible(true);
    }

}
