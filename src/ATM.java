import java.beans.Customizer;
import java.util.*;

public class ATM {

    // Could have one user (that can be both a customer or manager)
    private User currentUser;

    // Or we can keep them both separate
    private Customer currentCustomer;
    private Manager currentManager;

    //Lists of all users and accounts
    private ArrayList<Account> allAccounts;
    
    // public ATM(){
    //     this.allAccounts = Bank.db.queryUsersAccounts(this.currentUser.user_id);
    // }

    public ATM(User user){
        this.currentUser = user;
        this.allAccounts = Bank.db.queryUsersAccounts(user.user_id);
    }

    public void logout() {
        // Save all information to database
    }

    public void createAccount(String accountType) {
        // Charge a fee for account creation 
        // Use a factory for generating accounts? 
        // accountFactory.createAccount(User user, )
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

    //Setters

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    public void setCurrentManager(Manager currentManager) {
        this.currentManager = currentManager;
    }
}
