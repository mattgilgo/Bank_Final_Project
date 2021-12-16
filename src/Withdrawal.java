
public class Withdrawal extends Transaction {
    public Withdrawal(int transaction_id, double transaction_amount, int account_id) {
        super(transaction_id, "withdraw", transaction_amount, account_id);
    }
}
