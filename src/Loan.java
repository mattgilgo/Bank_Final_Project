
public class Loan extends Account {
    public Loan(int account_id, String user_id, double balance, String currency_name, String currency_symbol){
        super(account_id, user_id, "loan", balance, currency_name, currency_symbol);
    }

}
