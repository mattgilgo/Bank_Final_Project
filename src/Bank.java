public class Bank {
    private ATM atm;
    private UserLoginAndCreateUserGUI userLoginAndCreateUserGUI;

    public Bank(){

    }


    public void startBankSession(){
        this.atm = new ATM();
        this.userLoginAndCreateUserGUI = new UserLoginAndCreateUserGUI();
    }

    //Create the new user account and add to database
    public void createUserAccount() {

    }

    public void userLogin(String username, String password) {
        // Check that user exists in db
        // Determine from db if the user is a manager or customer

        
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
