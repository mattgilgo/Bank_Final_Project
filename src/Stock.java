import java.util.*;

public class Stock {

    private int stock_id;
    private String stock_ticker;
    private double stock_price;

    public Stock(int id, String ticker, double price) {
        this.stock_id = id;
        this.stock_ticker = ticker;
        this.stock_price = price;
    }

    // Add a toString()

    @Override 
    public String toString(){
        return getTicker() + " " + Double.toString(getPrice());
    }

    public String getTicker(){
        return this.stock_ticker;
    }

    public double getPrice(){
        return this.stock_price;
    }
    
}
