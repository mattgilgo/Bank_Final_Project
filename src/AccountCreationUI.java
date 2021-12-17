import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountCreationUI extends JFrame {
    // TODO this should be static somewhere else in classes that make sense
    public static final String[] SUPPORTED_CURRENCIES = {"USD", "BTC", "ETH"};
    public static final String[] SUPPORTED_TYPES = {"Checking", "Saving", "Loan", "Trading"};

    private JLabel currencyLabel;
    private JComboBox currencyDrop;
    private JLabel typeLabel;
    private JComboBox typeDrop;
    private JLabel feeLabel;
    private JLabel feeDisplay;
    private JButton createAccountButton;
    private JComboBox acctDrop;
    private JLabel chargeAcctLabel;
    private JPanel panel;
    private JTextField depositAmtField;
    private JLabel depostLabel;
    private ATM atm;

    public AccountCreationUI(ATM atm, double fee) {

        this.atm = atm;

        DefaultComboBoxModel<String> modelCurrency = new DefaultComboBoxModel<String>(SUPPORTED_CURRENCIES);
        DefaultComboBoxModel<String> modelTypes = new DefaultComboBoxModel<String>();
        DefaultComboBoxModel<String> modelAccounts = new DefaultComboBoxModel<String>(atm.getStringListOfAccounts());
        currencyDrop.setModel(modelCurrency);
        currencyDrop.setForeground(new Color(0).BLACK);
        currencyDrop.setBackground(new Color(0).LIGHT_GRAY);
        typeDrop.setModel(modelTypes);
        typeDrop.setForeground(new Color(0).BLACK);
        typeDrop.setBackground(new Color(0).LIGHT_GRAY);
        acctDrop.setModel(modelAccounts);
        acctDrop.setForeground(new Color(0).BLACK);
        acctDrop.setBackground(new Color(0).LIGHT_GRAY);
        feeDisplay.setText(String.format("$%s", Double.toString(fee)));
        setContentPane(panel);
        setTitle("Account Creation Portal");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currency = (String) currencyDrop.getSelectedItem();
                String acctType = (String) typeDrop.getSelectedItem();
                String acctToCharge = (String) acctDrop.getSelectedItem();
                Double amtToDeposit = Double.parseDouble(depositAmtField.getText());
                //TODO Charge the appropriate account for the balance

                // create account method called here
                atm.createAccount(acctType, amtToDeposit, currency); // TODO probably need more things passed
                dispose(); // close window when done
            }
        });
    }

    public void showUI(){
        setVisible(true);
    }

    public static void main(String[] args) {
        String[] userAccounts = {"checking USD", "savings BTC"};
        double fee = 3;
        Bank bank = new Bank();
        User user  = new Customer(0, "C", "mattg", "almostdone");
        bank.launchAtm(user);
        ATM atm = bank.getAtm();
        AccountCreationUI accountCreationUI = new AccountCreationUI(atm, fee);
        accountCreationUI.showUI();
    }

}
