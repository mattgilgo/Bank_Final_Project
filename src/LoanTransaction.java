
public class LoanTransaction extends Transaction {
    public LoanTransaction (String transaction_id, double transaction_amount, String account_id){
        super(transaction_id, "loan", transaction_amount, account_id);
    }
}
