
public abstract class User {

    protected String user_id;
    protected String user_type;
    protected String username;
    protected String password;

    public User(String user_id, String user_type, String username, String password){
        this.user_id = user_id;
        this.user_type = user_type;
        this.username = username;
        this.password = password;
    }

    public abstract void createAccount(String accountType);

    //Getters
    public String getUser_id(){
        return this.user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    //Setters
    public void setUser_id(String user_id){
        this.user_id = user_id;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
