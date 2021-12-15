
public class Currency {
    private String currency_type;
    private String currency_symbol;

    public Currency(String currency_type){
        this.currency_type = currency_type;
        this.currency_symbol = "$";
    }
    public Currency(String currency_type, String currency_symbol){
        this.currency_type = currency_type;
        this.currency_symbol = currency_symbol;
    }

    //Getters

    public String getCurrency_type() {
        return currency_type;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }

    //Setters

    public void setCurrency_type(String currency_type) {
        this.currency_type = currency_type;
    }

    public void setCurrency_symbol(String currency_symbol) {
        this.currency_symbol = currency_symbol;
    }
}
