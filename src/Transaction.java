import java.sql.Timestamp;

public abstract class Transaction {

    protected String transaction_id;
    protected String transaction_type;
    protected double transaction_amount;
    protected Timestamp timestamp;
    protected String account_id;

    public Transaction(String transaction_id, String transaction_type, double transaction_amount, String account_id) {
        this.transaction_id = transaction_id;
        this.transaction_type = transaction_type;
        this.transaction_amount=transaction_amount;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    //Getters

    public String getTransaction_id() {
        return transaction_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getAccount_id() {
        return account_id;
    }

    //Setters

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }
}
