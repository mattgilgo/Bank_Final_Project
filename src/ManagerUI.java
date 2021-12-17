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
<<<<<<< HEAD
=======
    private JButton seeUserInformationButton;
    private JButton seeAllUsersInformationButton;

>>>>>>> 04bc6d5bddb9059c5baadc9414fae982a6f1f1ec

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
<<<<<<< HEAD
                int account_id = (Integer.parseInt(((String) userDrop.getSelectedItem()).replaceAll("[\\D]", "")));
                // TODO get transactions for this user
=======
                int user_id = (Integer.parseInt(((String) userDrop.getSelectedItem()).replaceAll("[\\D]", "")));
                // TODO get transactions for this user and send to table UI
                TableUICreator table = new TableUICreator(Transaction.fieldNames, atm.viewTransactions(user_id));
                table.showTable();
>>>>>>> 04bc6d5bddb9059c5baadc9414fae982a6f1f1ec
            }
        });
        seeUserStocksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int account_id = (Integer.parseInt(((String) userDrop.getSelectedItem()).replaceAll("[\\D]", "")));
<<<<<<< HEAD
                // TODO get stocks for this user
=======
                // TODO get stocks for this user and send to table UI
>>>>>>> 04bc6d5bddb9059c5baadc9414fae982a6f1f1ec
            }
        });
        seeAllTransactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                // TODO get all user transactions
=======
                // TODO get all user transactions and send to table UI
                TableUICreator table = new TableUICreator(Transaction.fieldNames, atm.viewAllTransactions());
                table.showTable();
>>>>>>> 04bc6d5bddb9059c5baadc9414fae982a6f1f1ec
            }
        });
        seeAllStockHoldingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                // TODO get all user stocks
=======
                // TODO get all user stocks and send to table
            }
        });
        seeUserInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO get user information for specified user and send to table
                int user_id = (Integer.parseInt(((String) userDrop.getSelectedItem()).replaceAll("[\\D]", "")));
                // TODO get transactions for this user and send to table UI
                TableUICreator table = new TableUICreator(ReportTuple.fieldNames, atm.viewUserReport(user_id));
                table.showTable();
            }
        });
        seeAllUsersInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO get all user information and send to tableUI
                TableUICreator table = new TableUICreator(ReportTuple.fieldNames, atm.viewReport());
                table.showTable();
>>>>>>> 04bc6d5bddb9059c5baadc9414fae982a6f1f1ec
            }
        });
    }

    public void showUI() {
        setVisible(true);
    }

}
