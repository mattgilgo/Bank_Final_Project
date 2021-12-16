
public class LoanTransaction extends Transaction {
    public LoanTransaction (int transaction_id, double transaction_amount, int account_id){
        super(transaction_id, "loan", transaction_amount, account_id);
    }
}
