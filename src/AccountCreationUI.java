import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountCreationUI extends JFrame {
    // TODO this should be static somewhere else in classes that make sense
    public static final String[] SUPPORTED_CURRENCIES = {"USD", "BTC", "ETH"};
    public static final String[] SUPPORTED_TYPES = {"Saving", "Checking"};

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
    private ATM atm;

    public AccountCreationUI(ATM atm, String[] userAccounts, double fee) {

        this.atm = atm;

        DefaultComboBoxModel<String> modelCurrency = new DefaultComboBoxModel<String>(SUPPORTED_CURRENCIES);
        DefaultComboBoxModel<String> modelTypes = new DefaultComboBoxModel<String>(SUPPORTED_TYPES);
        DefaultComboBoxModel<String> modelAccounts = new DefaultComboBoxModel<String>(userAccounts);
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
                // create account method called here
                atm.createAccount(acctType); // TODO probably need more things passed
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
        ATM atm = new ATM(new Customer(1, "C", "test", "test"));
        AccountCreationUI accountCreationUI = new AccountCreationUI(atm, userAccounts, fee);
        accountCreationUI.showUI();
    }

}
