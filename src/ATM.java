import java.beans.Customizer;
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
        openUser();
    }

    public void logout() {
        // Save all information to database
    }

    public void openUser(){
        this.allAccounts.addAll(Bank.db.queryUsersAccounts(getCurrentUser().getUser_id()));
        CustomerUI customerUI = new CustomerUI(this);
        customerUI.showUI();
    }

    public void createAccountUI() {
        // Charge a fee for account creation 
        // Use a factory for generating accounts? 
        // accountFactory.createAccount(User user, )
        //Bank.db.createAccount(currentUser.getUser_id(), accountType, balance, currency_name);
        AccountCreationUI accountCreationUI = new AccountCreationUI(this, this.getCurrentUser().getFee());
        accountCreationUI.showUI();

    }
    public void createAccount(String accountType, String currency_name) {
        // Charge a fee for account creation
        // Use a factory for generating accounts?
        // accountFactory.createAccount(User user, )
        //Bank.db.createAccount(currentUser.getUser_id(), accountType, balance, currency_name);

    }

    public void closeAccount() {

    }

    public void requestLoan() {

    }

    public void withdrawMoney() {

    }

    public void depositMoney() {

    }

    public void viewTransactions() {
        // Could be overloaded for managers and customers
    }

    public void generateDailyReport() {

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
