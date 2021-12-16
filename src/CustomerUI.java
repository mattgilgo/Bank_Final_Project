import javax.swing.*;
import javax.swing.plaf.TableUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

// TODO add account balance field
// TODO withdraw/deposit
// TODO when you click dropdown refresh the accounts

public class CustomerUI extends JFrame {
    private JComboBox dropDown;
    private JLabel infoDisplay;
    private JLabel infoLabel;
    private JLabel accountLabel;
    private JPanel panel;
    private JButton transactionsButton;
    private JButton createAcctButton;


    public CustomerUI(ATM atm) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(atm.getStringListOfAccounts());
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
                infoDisplay.setText(Double.toString(atm.getAllAccounts().get(Integer.parseInt(((String) dropDown.getSelectedItem()).replaceAll("[\\D]", ""))).getBalance()));
                //System.out.println(atm.getAllAccounts().get(Integer.parseInt(((String) dropDown.getSelectedItem()).replaceAll("[\\D]", ""))).getBalance();
            }
        });

        transactionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO set off a table UI pass columns and data of all transactions
//                TableUICreator table = new TableUICreator(atm.viewTransactions());
//                table.showTable();
            }
        });

        createAcctButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO go to create account function, open create account UI
                atm.createAccountUI();

            }
        });
    }

    public void showUI() {
        setVisible(true);
    }

    public static void main(String[] args) {
        String[] accountsTypes = {"checking", "savings", "checking", "savings"};
        String[] accountsCurrencyNames = {"Dollars", "Ethereum", "Bit Coin", "Doge Coin"};
        String[] accountsCurrencySymbols = {"USD", "ETH", "BTC", "DOGE"};
        Bank bank = new Bank();
        User user  = new Customer(0, "C", "mattg", "almostdone");
        bank.launchAtm(user);
        ATM atm = bank.getAtm();
        ArrayList<Account> accountArrayList = new ArrayList<>();
        for (int i = 0; i < accountsTypes.length; i++) {
            accountArrayList.add(new Account( i, i+1, accountsTypes[i], 1000, accountsCurrencyNames[i], accountsCurrencySymbols[i]));
        }
        atm.setAllAccounts(accountArrayList);
        CustomerUI custUI = new CustomerUI(atm);
        custUI.showUI();
    }

}
