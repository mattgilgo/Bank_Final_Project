
public class Savings extends Account {
    public Savings(int account_id, int user_id, double balance, String currency_name, String currency_symbol){
        super(account_id, user_id, "savings", balance, currency_name, currency_symbol);
    }
}
