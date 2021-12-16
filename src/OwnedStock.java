import java.util.*;

public class OwnedStock extends Stock {
    private int account_id;
    private int stock_id;
    private double cash_balance;
    private double stock_buy_price;
    private double num_shares;
    private String ticker;
    private double current_price;
    
    
    public OwnedStock(int id, String ticker, double current_price, int accountId, double cashBalance, double buyPrice, double numShares) {
        super(id, ticker, current_price);
        this.account_id = accountId;
        this.cash_balance = cashBalance;
        this.stock_buy_price = buyPrice;
        this.num_shares = numShares;
    }
    
    
    
    
}
