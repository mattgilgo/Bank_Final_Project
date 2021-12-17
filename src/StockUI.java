import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

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

    private ATM atm;

    public StockUI(ATM atm) {

        this.atm = atm;

        DefaultComboBoxModel<String> modelStockDrop = new DefaultComboBoxModel<String>(stocksString());
        stockDrop.setModel(modelStockDrop);
        stockDrop.setForeground(new Color(0).BLACK);
        stockDrop.setBackground(new Color(0).LIGHT_GRAY);

        DefaultComboBoxModel<String> modelBankDrop = new DefaultComboBoxModel<String>(atm.getStringListOfStockAccounts());
        bankDrop.setModel(modelBankDrop);
        bankDrop.setForeground(new Color(0).BLACK);
        bankDrop.setBackground(new Color(0).LIGHT_GRAY);

        setContentPane(panel);
        setTitle("Stock Market Interface");
        setSize(600, 300);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stockTicker = (String) stockDrop.getSelectedItem();
                String ticker = stockTicker.split(" ")[0];
                System.out.println(ticker);
                Integer numShares = 0;
                try{
                    numShares = Integer.parseInt(shareNumberText.getText());
                }
                catch (NumberFormatException ignore){
                    System.out.println("Invalid Input!");
                }
                String bankAccount = (String) bankDrop.getSelectedItem();
                // TODO use provided info to make purchase
                atm.buyStock(ticker, numShares);
            }
        });
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String stockTicker = (String) stockDrop.getSelectedItem();
                Integer numShares = 0;
                try{
                    numShares = Integer.parseInt(shareNumberText.getText());;
                }
                catch (NumberFormatException ignore){
                    System.out.println("Invalid Input!");
                }
                String bankAccount = (String) bankDrop.getSelectedItem();
//                int stockInstance = Bank.db.getStockInstance(account_id, stockTicker); // need account_id here
//                if (stockInstance > 0) {
////                    Bank.db.transactOwnedStock(account_id, stockInstance, cashBalance, numShares, stockInstance); // need cashBalance here
//                }
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
                System.out.println(Arrays.toString(atm.getPortfolio()));
                TableUICreator tableUICreator = new TableUICreator(OwnedStock.fieldNames, atm.getPortfolio());
                tableUICreator.showTable();
            }
        });
    }

    public String[] stocksString() {
        ArrayList<Stock> stocks = Bank.db.queryStocks();
        String[] strings = new String[stocks.size()];
        for (int i=0; i < stocks.size(); i++) {
            strings[i] = stocks.get(i).toString();
        }
        return strings;
    }

    public void showUI(){
        setVisible(true);
    }

    public static void main(String[] args) {
//        String[] userAccounts = {"checking USD", "savings BTC"};
//        StockUI ui = new StockUI(userAccounts);
//        ui.showUI();
    }
}
