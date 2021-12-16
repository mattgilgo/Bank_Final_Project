
public class Deposit extends Transaction {

    public Deposit(int transaction_id, double transaction_amount, int account_id){
        super(transaction_id, "deposit", transaction_amount, account_id);
    }
}
