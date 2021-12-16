
public class Checking extends Account {

    public Checking(int account_id, String user_id, double balance, String currency_name, String currency_symbol){
        super(account_id, user_id, "checking", balance, currency_name, currency_symbol);
    }
}
