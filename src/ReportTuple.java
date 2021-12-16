import java.util.Objects;

public class ReportTuple {
    private int user_id;
    private String user_type;
    private String username;
    private String password;
    private int account_id;
    private String account_type;
    private double balance;
    private Currency currency;

    public ReportTuple(int user_id, String user_type, String username, String password, int account_id, String account_type, double balance, String currency_name, String currency_symbol){
        this.user_id = user_id;
        this.user_type = user_type;
        this.username = username;
        this.password = password;
        this.account_id = account_id;
        this.account_type = account_type;
        this.balance = balance;
        this.currency = new Currency(currency_name, currency_symbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportTuple that = (ReportTuple) o;
        return user_id == that.user_id && account_id == that.account_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, account_id);
    }

    @Override
    public String toString() {
        return "ReportTuple{" +
                "user_id=" + user_id +
                ", user_type='" + user_type + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account_id=" + account_id +
                ", account_type='" + account_type + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }

    //getters

    public int getUser_id() {
        return user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAccount_id() {
        return account_id;
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

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
