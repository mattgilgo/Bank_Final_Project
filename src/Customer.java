import java.util.ArrayList;

public class Customer extends User {
    private ArrayList<Account> userAccounts;
    public Customer( String user_type, String username, String password){
        super(user_type, username, password);
    }
    public Customer(int user_id, String user_type, String username, String password){
        super(user_id, user_type, username, password);
    }

    @Override
    public void createAccount(String accountType) {

    }


}
