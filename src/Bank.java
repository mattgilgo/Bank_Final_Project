public class Bank {
    private ATM atm;
    private LoginUI userLoginAndCreateUserGui;
    private Database db;

    public Bank(){
        this.db = new Database();
    }


    public void startBankSession(){
        this.atm = new ATM();
        this.userLoginAndCreateUserGui = new LoginUI(this);
    }

    //Create the new user account and add to database
    public void createUserAccount(String user_type, String username, String password) {
        if(user_type.equals("Customer")){
            Customer customer = new Customer(user_type, username, password);
            db.insertUser(customer.getUser_type(), customer.getUsername(), customer.getPassword());
        }
        else{
            Manager manager = new Manager(user_type, username, password);
            db.insertUser(manager.getUser_type(), manager.getUsername(), manager.getPassword());
        }
    }

    public boolean userLogin(String username, String password) {
        // Check that user exists in db
        // Determine from db if the user is a manager or customer
        return db.checkUserLogin(username, password);
    }

    //getters

    public ATM getAtm() {
        return atm;
    }

    //Setters

    public void setAtm(ATM atm) {
        this.atm = atm;
    }
}
