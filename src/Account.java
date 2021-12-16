import java.util.Objects;

public class Account {  // matt removed abstract b/c it wasn't able to make an Account object when querying them in Database

    protected int account_id;
    protected int user_id;
    protected String account_type;
    protected double balance;
    protected Currency currency;


    public Account(){
        //this.account_id=account_id;
        this.account_type = "";
        this.user_id = Integer.MAX_VALUE;
        this.balance = 0;
        this.currency = new Currency("", "");
    }
    //Create account with zero balance
    public Account( int user_id,String account_type, String currency_name, String currency_symbol){
        //this.account_id=account_id;
        this.account_type = account_type;
        this.user_id = user_id;
        this.balance = 0;
        this.currency = new Currency(currency_name, currency_symbol);
    }

    public Account(int account_id, int user_id,String account_type, double balance, String currency_name, String currency_symbol){
        this.account_id=account_id;
        this.account_type = account_type;
        this.user_id = user_id;
        this.balance = balance;
        this.currency = new Currency(currency_name, currency_symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return account_id == account.account_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_id);
    }

//Getters

    public int getAccount_id() {
        return account_id;
    }

    public int getUser_id() {
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

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
