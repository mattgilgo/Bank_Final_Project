import java.sql.*;
import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Database {
    
    Connection conn;
    private Factory factory;

    public Database(){
        this.factory = new Factory();
        getConnection();
        
        
    }

    private void getConnection(){
        try
            {
            // Construct path to .db file
            Path currentPath = Paths.get(System.getProperty("user.dir"));
            Path filePath = Paths.get(currentPath.toString(), "Bank.db");
            
            Class.forName("org.sqlite.JDBC");
            String myUrl = "jdbc:sqlite:" + filePath.toString();
            System.out.println(myUrl);
            conn = DriverManager.getConnection(myUrl, "root", "");
            
            }
        catch (Exception e)
            {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
            }
    }

    public void insertUser(String userType, String userName, String password) {
        String sql = "INSERT INTO users(user_type,username,password) VALUES(?,?,?)";

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userType);
            pstmt.setString(2, userName);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User getUser(int userId){
        String sql = "SELECT user_type, username, password FROM users WHERE user_id = ?";
        
        try (
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setInt(1,userId);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            rs.next();
            String userType = rs.getString("user_type");
            if (userType.equals("C")){
                return new Customer(userId, rs.getString("username"), rs.getString("username"), rs.getString("password"));
            } else if (userType.equals("M")) {
                return new Manager(userId, rs.getString("username"), rs.getString("username"), rs.getString("password"));
            }

        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return null;
        
    }

    

    public User checkLogin(String username, String password){
        String sql = "SELECT * FROM users WHERE username = ?";
        
        try (
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setString(1,username);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while(rs.next()) {
                String userType = rs.getString("user_type");
                String passwordCheck = rs.getString("password");
                if (password.equals(passwordCheck)){
                    if (userType.equals("C")){
                        return new Customer(rs.getInt("user_id"), rs.getString("user_type"), rs.getString("username"), rs.getString("password"));
                    } else if (userType.equals("M")) {
                        return new Manager(rs.getInt("user_id"), rs.getString("user_type"), rs.getString("username"), rs.getString("password"));
                    }
                }
                
            }

        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return null;
        
    }

    public boolean checkUserLogin(String username, String password){
        String sql = "SELECT * FROM users WHERE username = ?";

        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setString(1,username);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                String userType = rs.getString("user_type");
                String passwordCheck = rs.getString("password");
                if (password.equals(passwordCheck)){
                    return true;
                }

            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return false;

    }


    public void createAccount(int user_id, String account_type, double balance, String currency_type) {
        String sql = "INSERT INTO accounts(user_id,account_type,balance,currency_name,currency_symbol) VALUES(?,?,?,?,?)";

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, user_id);
            pstmt.setString(2, account_type);
            pstmt.setDouble(3, balance); // initial balance at $0, add fee later
            pstmt.setString(4, currency_type);
            pstmt.setString(5, currency_type);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Account> queryUsersAccounts(int user_id) {
        ArrayList<Account> allAccounts =  new ArrayList<Account>();
        allAccounts.add(new Account());
        String sql = "SELECT * FROM accounts WHERE user_id = ?";

        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,user_id);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int accountId = rs.getInt("account_id");
                String accountType = rs.getString("account_type");
                double balanceCheck = rs.getDouble("balance");
                String currency_name = rs.getString("currency_name");
                String currency_symbol = rs.getString("currency_symbol");
                Account userAccount = new Account(accountId, user_id, accountType, balanceCheck, currency_name, currency_symbol);
                allAccounts.add(userAccount);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return allAccounts;
    }
    public Report getAllAccountsReport() {
        Report report =  new Report();
        String sql = "SELECT u.user_id as user_id, u.user_type, u.username, u.password, a.user_id as acc_user_id, a.account_id, a.account_type, a.balance, a.currency_name, a.currency_symbol FROM accounts as a, users as u WHERE u.user_id = a.user_id";
        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){

            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_type = rs.getString("user_type");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int acc_user_id = rs.getInt("acc_user_id");
                int accountId = rs.getInt("account_id");
                String accountType = rs.getString("account_type");
                double balanceCheck = rs.getDouble("balance");
                String currency_name = rs.getString("currency_name");
                String currency_symbol = rs.getString("currency_symbol");
                ReportTuple reportTuple = new ReportTuple( user_id, user_type, username, password, accountId, accountType, balanceCheck, currency_name, currency_symbol);
                report.getReportTuples().add(reportTuple);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return report;
    }
    public Report getUserReport(int user_id) {
        Report report =  new Report();
        String sql = "SELECT u.user_id as user_id, u.user_type, u.username, u.password, a.user_id as acc_user_id, a.account_id, a.account_type, a.balance, a.currency_name, a.currency_symbol FROM accounts as a, users as u WHERE u.user_id = a.user_id AND u.user_id = ?";
        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
            //Set user_id
            pstmt.setInt(1,user_id);
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int query_user_id= rs.getInt("user_id");
                String user_type = rs.getString("user_type");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int acc_user_id = rs.getInt("acc_user_id");
                int accountId = rs.getInt("account_id");
                String accountType = rs.getString("account_type");
                double balanceCheck = rs.getDouble("balance");
                String currency_name = rs.getString("currency_name");
                String currency_symbol = rs.getString("currency_symbol");
                ReportTuple reportTuple = new ReportTuple( query_user_id, user_type, username, password, accountId, accountType, balanceCheck, currency_name, currency_symbol);
                report.getReportTuples().add(reportTuple);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return report;
    }

    public void createTransaction(String transType, double transAmount, int accountId) {
        String sql = "INSERT INTO transactions(transaction_type,transaction_amount,account_id) VALUES(?,?,?)";

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, transType);
            pstmt.setDouble(2, transAmount);
            pstmt.setInt(3, accountId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // query transaction log for bank, do by date later
    public ArrayList<Transaction> queryUserTransactions(int userId) {
        ArrayList<Transaction> userTransactions =  new ArrayList<Transaction>();

        String sql = "SELECT T.transaction_id, T.transaction_type, T.transaction_amount, T.transaction_time, T.account_id as account_id FROM transactions T, accounts A WHERE T.account_id = A.account_id AND A.user_id = ?";

        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            pstmt.setInt(1, userId);
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int transId = rs.getInt("transaction_id");
                String transType = rs.getString("transaction_type");
                double transAmount = rs.getDouble("transaction_amount"); // is this a new column? 
                Timestamp timestamp = rs.getTimestamp("transaction_time"); // not sure this one is in current db either
                int accountId = rs.getInt("account_id");
                Transaction trans = new Transaction(transId, transType, transAmount, timestamp, accountId);
                userTransactions.add(trans);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return userTransactions;
    }
    // query transaction log for bank, do by date later
    public ArrayList<Transaction> queryAllTransactions() {
        ArrayList<Transaction> allTransactions =  new ArrayList<Transaction>();

        String sql = "SELECT T.transaction_id, T.transaction_type, T.transaction_amount, T.transaction_time, T.account_id as account_id FROM transactions T, accounts A WHERE T.account_id = A.account_id";

        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int transId = rs.getInt("transaction_id");
                String transType = rs.getString("transaction_type");
                double transAmount = rs.getDouble("transaction_amount"); // is this a new column?
                Timestamp timestamp = rs.getTimestamp("transaction_time"); // not sure this one is in current db either
                int accountId = rs.getInt("account_id");
                Transaction trans = new Transaction(transId, transType, transAmount, timestamp, accountId);
                allTransactions.add(trans);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return allTransactions;
    }

    public void createStock(String ticker, double price) {
        String sql = "INSERT INTO stocks(stock_ticker,stock_price) VALUES(?,?)";

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticker);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Stock> queryStocks() {
        ArrayList<Stock> allStocks =  new ArrayList<Stock>();

        String sql = "SELECT * FROM stocks";

        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){

            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int stockId = rs.getInt("stock_id");
                String ticker = rs.getString("stock_ticker");
                double price = rs.getDouble("stock_price");
                Stock stock = new Stock(stockId, ticker, price);
                allStocks.add(stock);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return allStocks;
    }

    public double getStockPrice(String ticker) {
        double stockPrice = 0;
        String sql = "SELECT stock_price from stocks where stock_ticker = ?"; 

        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
                    pstmt.setString(1, ticker);
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                stockPrice = rs.getDouble("stock_price");
//                System.out.printf("Stock price in iterator: %s\n", stockPrice);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return stockPrice;
    }

    public int getStockId(String ticker) {
        String sql = "SELECT stock_id from stocks where stock_ticker = ?"; 

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, ticker);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    public void createStockOwned(int accountId, int stockId, double buyPrice, double numShares) {
        String sql = "INSERT INTO stocks_owned(account_id, stock_id, stock_buy_price,num_shares) VALUES(?,?,?,?)";
        System.out.println("creating stock owned");

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, accountId);
            pstmt.setInt(2, stockId);
            pstmt.setDouble(3, buyPrice);
            pstmt.setDouble(4, numShares);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<OwnedStock> queryAccountsStocks(int account_id) {
        ArrayList<OwnedStock> allAccountsStocks =  new ArrayList<OwnedStock>();

        String sql = "SELECT s.stock_id, s.stock_ticker, s.stock_price, so.stock_buy_price, so.num_shares" + 
            "FROM stocks s LEFT JOIN stocks_owned so on s.stock_id=so.stock_id WHERE account_id=?";

        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,account_id);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int stockId = rs.getInt("stock_id");
                String ticker = rs.getString("stock_ticker");
                double currentPrice = rs.getDouble("stock_price");
                double buyPrice = rs.getDouble("stock_buy_price");
                double numShares = rs.getDouble("num_shares");
                OwnedStock ownedStock = new OwnedStock(stockId, ticker, currentPrice, account_id, buyPrice, numShares);
                allAccountsStocks.add(ownedStock);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return allAccountsStocks;
    }

    public ArrayList<OwnedStock> getPortfolio(int account_id) {
        ArrayList<OwnedStock> allAccountsStocks =  new ArrayList<OwnedStock>();

        String sql = "SELECT s.stock_id, s.stock_ticker, s.stock_price, so.stock_buy_price, SUM(so.num_shares) AS num_shares " +
        "FROM stocks s, stocks_owned so " + 
        "WHERE s.stock_id=so.stock_id AND so.account_id=? " + 
        "GROUP BY s.stock_id"; 
        
      
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,account_id);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int stockId = rs.getInt("stock_id");
                String ticker = rs.getString("stock_ticker");
                double currentPrice = rs.getDouble("stock_price");
                double buyPrice = rs.getDouble("stock_buy_price");
                double numShares = rs.getDouble("num_shares");
                OwnedStock ownedStock = new OwnedStock(stockId, ticker, currentPrice, account_id, buyPrice, numShares);
                System.out.println(ownedStock);
                allAccountsStocks.add(ownedStock);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return allAccountsStocks;
    }

    public ArrayList<OwnedStock> getStockTrades(int account_id) {
        ArrayList<OwnedStock> allAccountsStocks =  new ArrayList<OwnedStock>();

        String sql = "SELECT s.stock_id, s.stock_ticker, s.stock_price, so.stock_buy_price, so.num_shares " +
        "FROM stocks s, stocks_owned so " +
        "WHERE s.stock_id = so.stock_id AND so.account_id=?";  

        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,account_id);
            //
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int stockId = rs.getInt("stock_id");
                String ticker = rs.getString("stock_ticker");
                double currentPrice = rs.getDouble("stock_price");
                double buyPrice = rs.getDouble("stock_buy_price");
                double numShares = rs.getDouble("num_shares");
                OwnedStock ownedStock = new OwnedStock(stockId, ticker, currentPrice, account_id, buyPrice, numShares);
                allAccountsStocks.add(ownedStock);
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return allAccountsStocks;
    }

    public int getStockInstance(int account_id, String ticker) {
//        String sql = "SELECT stock_instance_owned_id FROM stocks_owned WHERE account_id = ? AND stock_ticker = ?";
        String sql = "SELECT so.stock_instance_owned_id FROM stocks_owned so, stocks s WHERE s.stock_id = so.stock_id AND account_id = ? AND stock_ticker = ?";
        int stockInstance = 0;
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){

        // set the value
        pstmt.setInt(1,account_id);
        pstmt.setString(2,ticker);
        //
        ResultSet rs  = pstmt.executeQuery();

        // loop through the result set
        while(rs.next()) {
            stockInstance = rs.getInt("stock_instance_owned_id");
        }

        

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        if (stockInstance > 0) {
            System.out.printf("User owns stock %s\n", stockInstance);
            return stockInstance;
        } else {
            System.out.println("User does not own this stock!");
            return stockInstance;
        }
    
    }

    public double getCurrentNumShares(int stockInstance) {
//        String sql = "SELECT num_shares from stocks_owned where stock_instance_owned_id = ?";
        String sql = "SELECT num_shares from stocks_owned where stock_instance_owned_id = ?";
        double numShares = 0;

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, stockInstance);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                numShares = rs.getDouble("num_shares");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numShares;
    }

    public void transactOwnedStock(int accountId, String ticker, double num_shares, int stockInstance) {
        // String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";

        // try (
        //     PreparedStatement pstmt = conn.prepareStatement(sql)) {
        //     pstmt.setDouble(1, newAccountBalance);
        //     pstmt.setInt(2, account_id);
        //     pstmt.executeUpdate();
        // } catch (SQLException e) {
        //     System.out.println(e.getMessage());
        // }

        String sqltwo = "UPDATE stocks_owned SET num_shares = ? WHERE stock_instance_owned_id = ?";
        System.out.println("updating owned stock");

        try (
            PreparedStatement pstmt = conn.prepareStatement(sqltwo)) {
            pstmt.setDouble(1, num_shares);
            pstmt.setInt(2, stockInstance);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    

    public double getAccountBalance(int account_id) {
        String sql = "SELECT balance from accounts WHERE account_id = ?";
        double balance = 0;
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){

        // set the value
        pstmt.setInt(1,account_id);
        //
        ResultSet rs  = pstmt.executeQuery();

        // loop through the result set
        while(rs.next()) {
            balance = rs.getDouble("balance");
        }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return balance;
    }

    public void setAccountBalance(int account_id, double newBal) {
        String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";

        try (
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, newBal);
            pstmt.setInt(2, account_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public ArrayList<User> getAllUsers(){
        String sql = "SELECT * FROM users";
        ArrayList<User> allUsers = new ArrayList<>();
        try (
                PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();

            // loop through the result set
            while(rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_type = rs.getString("user_type");
                String username = rs.getString("username");
                String password = rs.getString("password");
                User tempUser = factory.createUser(user_id, user_type, username, password);
                allUsers.add(tempUser);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allUsers;
    }

    // Everything below here is for testing 
    public void printAllUsers(){
        String sql = "SELECT * FROM users";
        
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while(rs.next()) {
                System.out.println(rs.getInt("user_id") + " " + rs.getString("username") + " " + rs.getString("user_type") + " " + rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }

    public void printAllAccounts(){
        String sql = "SELECT * FROM accounts";
        
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();
            
            int accountId = rs.getInt("account_id");

            // loop through the result set
            while(rs.next()) {
                System.out.println(rs.getString("account_type") + " " + rs.getDouble("balance") + " " + rs.getString("currency_name") + " " + rs.getString("currency_symbol"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
            
    }

    public void printAllTransactions(){
        String sql = "SELECT * FROM transactions";
        
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();
          
            // loop through the result set
            while(rs.next()) {
                System.out.println(rs.getInt("transaction_id") + " " + rs.getString("transaction_type") + " " + rs.getInt("account_id") + " " + rs.getDouble("transaction_amount") + " " + rs.getTimestamp("transaction_time"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
            
            
    }

    public void printAllStocks(){
        String sql = "SELECT * FROM stocks";
        
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while(rs.next()) {
                System.out.println(rs.getInt("stock_id") + " " + rs.getString("stock_ticker") + " " + rs.getDouble("stock_price"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
             
    }

    public void printAllStocksOwned(){
        String sql = "SELECT * FROM stocks_owned";
        
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();
        
            // loop through the result set
            while(rs.next()) {
                System.out.println(rs.getInt("account_id") + " " + rs.getInt("stock_id") + " " + rs.getDouble("cash_balance") + " " + rs.getDouble("stock_buy_price") + " " + rs.getDouble("num_shares"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
             
    }
    

    public static void main(String[] args) {
        Database db = new Database();
        // db.printAllUsers();
        // db.printAllAccounts();
        // db.printAllTransactions();
        // db.printAllStocks();
        // db.printAllStocksOwned();
        ArrayList<Transaction> user_transactions = db.queryUserTransactions(1);
        ArrayList<OwnedStock> stocks = db.getPortfolio(1);
        for (OwnedStock stock: stocks) {
            System.out.println(stock);
        }
    }

//    public int getCurrentNumShares(int stockInstance) {
//        return 1;
//    }
}


