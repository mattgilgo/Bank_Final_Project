import java.util.Objects;

public abstract class User {

    protected int user_id;
    protected String user_type;
    protected String username;
    protected String password;
    //private Database db;

    public User(String user_type, String username, String password){
        this.user_type = user_type;
        this.username = username;
        this.password = password;
        //this.db  = new Database();
    }
    public User(int user_id, String user_type, String username, String password){
        this.user_id = user_id;
        this.user_type = user_type;
        this.username = username;
        this.password = password;
    }

    public abstract void createAccount(String accountType);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }

    //Getters
    public int getUser_id(){
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
    public void setUser_id(int user_id){
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
