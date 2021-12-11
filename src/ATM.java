import java.beans.Customizer;

public class ATM {

    // Could have one user (that can be both a customer or manager)
    private User currentUser;

    // Or we can keep them both separate
    private Customer currentCustomer;
    private Manager currentManager;
    
    public ATM(){
        
    }

    public ATM(Customer customer) {

    }

    public ATM(Manager manager) {
        
    }

    public void login(String username, String password){
        // Check backend db for username and password
        // Set the current user (can be a manager or customer) 
        currentUser = null;
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

}
