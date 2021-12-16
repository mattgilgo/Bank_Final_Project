import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockUI extends JFrame {
    // TODO Supported currencies variable should be moved to where it makes sense
    public static final String[] SUPPORTED_STOCKS = new String[]{"BTC", "ETH", "AAPL", "ORCL"};

    private JButton seePortfolioButton;
    private JButton seeBuysSellsButton;
    private JComboBox stockDrop;
    private JTextField shareNumberText;
    private JButton buyButton;
    private JButton sellButton;
    private JComboBox bankDrop;
    private JLabel stockLabel;
    private JLabel equityValue;
    private JLabel equityLabel;
    private JPanel panel;

    public StockUI(String[] userAccounts) {

        DefaultComboBoxModel<String> modelStockDrop = new DefaultComboBoxModel<String>(SUPPORTED_STOCKS);
        stockDrop.setModel(modelStockDrop);
        stockDrop.setForeground(new Color(0).BLACK);
        stockDrop.setBackground(new Color(0).LIGHT_GRAY);

        DefaultComboBoxModel<String> modelBankDrop = new DefaultComboBoxModel<String>(userAccounts);
        bankDrop.setModel(modelBankDrop);
        bankDrop.setForeground(new Color(0).BLACK);
        bankDrop.setBackground(new Color(0).LIGHT_GRAY);

        setContentPane(panel);
        setTitle("Stock Market Interface");
        setSize(600, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stockTicker = (String) stockDrop.getSelectedItem();
                Integer numShares = Integer.parseInt(shareNumberText.getText());
                String bankAccount = (String) bankDrop.getSelectedItem();
                // TODO use provided info to make purchase
            }
        });
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stockTicker = (String) stockDrop.getSelectedItem();
                Integer numShares = Integer.parseInt(shareNumberText.getText());
                String bankAccount = (String) bankDrop.getSelectedItem();
                int stockInstance = Bank.db.getStockInstance(account_id, stockTicker); // need account_id here
                if (stockInstance > 0) {
                    Bank.db.transactOwnedStock(account_id, stockInstance, cashBalance, numShares, stockInstance); // need cashBalance here
                }
            }
        });
        seeBuysSellsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO produce tableUI and pass columns, data for stock transactions
            }
        });
        seePortfolioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO produce tableUI and pass columns, data for stocks owned, amt, price, value
            }
        });
    }

    public void showUI(){
        setVisible(true);
    }

    public static void main(String[] args) {
        String[] userAccounts = {"checking USD", "savings BTC"};
        StockUI ui = new StockUI(userAccounts);
        ui.showUI();
    }
}
