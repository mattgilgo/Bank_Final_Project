/*
Factory class implements the factory design patter by creating the appropriate object type for each account type.
 */
public class Factory {
    //Method returns the appropriately instantiated Hero object by creating either a Sorcerer, Warrior, Paladin, or generic Hero
    public Account createAccount(int account_id, int user_id,String account_type, double balance, String currency_name, String currency_symbol) {
        Account account;
        if(account_type.equalsIgnoreCase("checking")){
            account = new Checking(account_id, user_id, balance, currency_name, currency_symbol );
        }
        else if (account_type.equalsIgnoreCase("saving")){
            account = new Savings(account_id, user_id, balance, currency_name, currency_symbol );
        }
        else if (account_type.equalsIgnoreCase("loan")){
            account = new Loan(account_id, user_id, balance, currency_name, currency_symbol );
        }
        else if (account_type.equalsIgnoreCase("trading")){
            account = new Trading(account_id, user_id, balance, currency_name, currency_symbol );
        }
        else{
            account=null;
        }
        return account;
    }
    public User createUser(int user_id, String user_type,String username, String password) {
        User user;
        if(user_type.equalsIgnoreCase("C")){
            user = new Customer(user_id, user_type, username, password);
        }
        else if (user_type.equalsIgnoreCase("M")){
            user = new Manager(user_id, user_type, username, password);
        }
        else{
            user=null;
        }
        return user;
    }
}
