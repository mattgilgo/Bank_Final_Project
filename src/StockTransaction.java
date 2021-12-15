
public class StockTransaction extends Transaction {
    public StockTransaction(String transaction_id, double transaction_amount, String account_id) {
        super(transaction_id, "stock", transaction_amount, account_id);
    }
}
