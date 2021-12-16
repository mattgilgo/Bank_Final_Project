
public class Withdrawal extends Transaction {
    public Withdrawal(String transaction_id, double transaction_amount, String account_id) {
        super(transaction_id, "withdraw", transaction_amount, account_id);
    }
}
