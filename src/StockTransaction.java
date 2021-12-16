
public class StockTransaction extends Transaction {
    public StockTransaction(int transaction_id, double transaction_amount, int account_id) {
        super(transaction_id, "stock", transaction_amount, account_id);
    }
}
