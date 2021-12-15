
public class Deposit extends Transaction {

    public Deposit(String transaction_id, double transaction_amount, String account_id){
        super(transaction_id, "deposit", transaction_amount, account_id);
    }
}
