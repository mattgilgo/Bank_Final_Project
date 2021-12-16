import java.util.*;

public class OwnedStock extends Stock {
    public static String[] fieldNames = {"stock_ticker", "current_price", "buy_price", "number_of_shares"};
    
    private int account_id;
    private int stock_id;
    private double cash_balance;
    private double stock_buy_price;
    private double num_shares;
    private String ticker;
    private double current_price;
    
    
    public OwnedStock(int id, String ticker, double current_price, int accountId, double buyPrice, double numShares) {
        super(id, ticker, current_price);
        this.account_id = accountId;
        this.stock_buy_price = buyPrice;
        this.num_shares = numShares;
    }
    
    public double getBuyPrice() {
        return this.stock_buy_price;
    }
    
    public double getNumShares() {
        return this.num_shares;
    }
    
    
}
