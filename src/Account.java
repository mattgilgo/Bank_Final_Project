
public abstract class Account {

    protected String account_id;
    protected String user_id;
    protected String account_type;
    protected double balance;
    protected Currency currency;

    //Create account with zero balance
    public Account(String account_id, String user_id,String account_type, String currency_name, String currency_symbol){
        this.account_id=account_id;
        this.account_type = account_type;
        this.user_id = user_id;
        this.balance = 0;
        this.currency = new Currency(currency_name, currency_symbol);
    }

    public Account(String account_id, String user_id,String account_type, double balance){
        this.account_id=account_id;
        this.account_type = account_type;
        this.user_id = user_id;
        this.balance = balance;
    }

    //Getters

    public String getAccount_id() {
        return account_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public double getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    //Setters

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}