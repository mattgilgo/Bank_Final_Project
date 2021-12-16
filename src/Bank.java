public class Bank {
    private ATM atm;
    private LoginUI userLoginAndCreateUserGui;
    public static Database db;

    public Bank(){
        db = new Database();
    }


    public void startBankSession(){
        this.userLoginAndCreateUserGui = new LoginUI(this);
    }

    //Create the new user account and add to database
    public void createUserAccount(String user_type, String username, String password) {
        if(user_type.equals("C")){
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

    public void launchAtm(User user){
        this.atm = new ATM(user);
        if(user.getUser_type().equals("C")){
            atm.setCurrentCustomer(new Customer(user.getUser_id(), user.getUser_type(), user.getUsername(), user.getPassword()));
        }
        else{
            atm.setCurrentManager(new Manager(user.getUser_id(), user.getUser_type(), user.getUsername(), user.getPassword()));
        }
    }
    //getters

    public ATM getAtm() {
        return atm;
    }

    public static Database getDb() {
        return db;
    }

    //Setters

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public static void setDb(Database db) {
        Bank.db = db;
    }
}
