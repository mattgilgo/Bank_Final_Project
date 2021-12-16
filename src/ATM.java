import java.beans.Customizer;
import java.lang.reflect.Array;
import java.util.*;

public class ATM {
    private Factory factory;

    // Could have one user (that can be both a customer or manager)
    private User currentUser;

    // Or we can keep them both separate
    private Customer currentCustomer;
    private Manager currentManager;

    //Lists of all users and accounts
    private ArrayList<Account> allAccounts;
    
    /*public ATM(){
         this.allAccounts = Bank.db.queryUsersAccounts(this.currentUser.user_id);
    }*/

    public ATM(User user){
        this.currentUser = user;
        this.allAccounts = new ArrayList<Account>();

        if(user.getUser_type().equalsIgnoreCase("C")){
            currentCustomer = new Customer(user.getUser_id(), user.getUser_type(), user.getUsername(), user.getPassword());
            openUser();
        }
        else{
            currentManager = new Manager(user.getUser_id(), user.getUser_type(), user.getUsername(), user.getPassword());
            openManager();
        }
    }

    public void logout() {
        // Save all information to database
    }

    public void openUser(){
        this.allAccounts.addAll(Bank.db.queryUsersAccounts(getCurrentUser().getUser_id()));
        createCustomerUI();
    }
    public void openManager(){
        //TODO Add Manager Report UI
        System.out.println(currentManager.getUsername());
        System.out.println(currentManager.getReport());
    }

    public void createAccountUI() {
        // Charge a fee for account creation 
        // Use a factory for generating accounts? 
        // accountFactory.createAccount(User user, )
        //Bank.db.createAccount(currentUser.getUser_id(), accountType, balance, currency_name);
        AccountCreationUI accountCreationUI = new AccountCreationUI(this, this.getCurrentUser().getFee());
        accountCreationUI.showUI();

    }
    public void createAccount(String accountType, double balance, String currency_name) {
        // Charge a fee for account creation
        // Use a factory for generating accounts?
        // accountFactory.createAccount(User user, )
        // TODO: Add check for "stock" account 
        Bank.db.createAccount(currentUser.getUser_id(), accountType, balance, currency_name);
        updateUserAccounts();
        createCustomerUI();
    }
    public void createCustomerUI(){
        CustomerUI customerUI = new CustomerUI(this);
        customerUI.showUI();
    }

    public void closeAccount() {

    }

    public boolean requestLoan(double loanAmount, String currency_type) {
        // Check their total wealth - return false if not approved
        double totalWealth = 0;
        for (Account act: allAccounts) {
            totalWealth += act.getBalance();
        }

        if (totalWealth > 100.00) {
            // Grant loan
            Bank.db.createAccount(getCurrentUser().getUser_id(), "L", loanAmount, currency_type);
            return true;
        }

        return false;
    }

    public void withdrawMoney(int accountId, double amount) {
        for (Account act: allAccounts) {
            if (act.getAccount_id() == accountId) {
                Bank.db.setAccountBalance(act.getAccount_id(), act.getBalance()-amount);
                Bank.db.createTransaction("withdraw", amount, accountId);
                updateUserAccounts();
            }
        }
        
    }

    public void depositMoney(int accountId, double amount) {
        for (Account act: allAccounts) {
            if (act.getAccount_id() == accountId) {
                Bank.db.setAccountBalance(act.getAccount_id(), act.getBalance()+amount);
                Bank.db.createTransaction("deposit", amount, accountId);
                updateUserAccounts();
            }
        }
    }

    public Object[][] viewTransactions(int userId) {
        // Could be overloaded for managers and customers
        ArrayList<Transaction> transactions = Bank.db.queryTransactions(userId);
        Object[][] data = new Object[transactions.size()][];

        for (int i=0; i<transactions.size(); i++) {
            data[i] = transactions.get(i).getStringArray();
        }
        return data;
    }
    public Object[][] viewReport() {
        // Could be overloaded for managers and customers
        ArrayList<ReportTuple> reportTuples = currentManager.getReport().getReportTuples();
        Object[][] data = new Object[reportTuples.size()][];

        for (int i=0; i<reportTuples.size(); i++) {
            data[i] = reportTuples.get(i).getStringArray();
        }
        return data;
    }

    public void updateUserAccounts(){
        this.setAllAccounts(Bank.db.queryUsersAccounts(getCurrentUser().getUser_id()));
    }
    public void generateDailyReport() {

    }

    public void buyStock(){

    }

    public void sellStock(){

    }

    public void getTrades(){

    }

    public String[][] getPortfolio(){
        // groupby on stock_id sum num_shares - return array of strings
        ArrayList<OwnedStock> currentPortfolio = new ArrayList<OwnedStock>();
        for (Account act: allAccounts) {
            if (act.getAccount_type().equals("ST")) {
                currentPortfolio = Bank.db.getPortfolio(act.getAccount_id());
            }
        }

        // Unpack stocks into GUI readable string 
        String[][] portfolio = new String[currentPortfolio.size()][4];
        for (int i=0; i<currentPortfolio.size(); i++) {
            String[] stockArray = {currentPortfolio.get(i).getTicker(), Double.toString(currentPortfolio.get(i).getPrice()), Double.toString(currentPortfolio.get(i).getBuyPrice()), Double.toString(currentPortfolio.get(i).getNumShares())};
            portfolio[i] = stockArray;
        }

        return portfolio;
    }

    




    //Getters

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public Manager getCurrentManager() {
        return currentManager;
    }

    public ArrayList<Account> getAllAccounts() {
        return allAccounts;
    }

    public String[] getStringListOfAccounts(){
        String[] allAccountInfo = new String[allAccounts.size()];
        for (int i = 0; i < allAccounts.size(); i++) {
            Account a = allAccounts.get(i);
            allAccountInfo[i] = a.getAccount_id() + " " + a.getAccount_type() +" "+ a.getCurrency().getCurrency_symbol();
        }
        return allAccountInfo;
    }

    public User getCurrentUser() {
        return currentUser;
    }
    //Setters

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public void setCurrentManager(Manager currentManager) {
        this.currentManager = currentManager;
    }

    public void setAllAccounts(ArrayList<Account> allAccounts){
        this.allAccounts = allAccounts;
    }
}
