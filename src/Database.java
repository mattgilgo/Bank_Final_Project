import java.sql.*;


public class Database {
    
    Connection conn;
    
    public Database(){
        getConnection();
        
        
    }

    private void getConnection(){
        try
            {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(myDriver);
            String myUrl = "jdbc:mysql://localhost:3306/bank";
            conn = DriverManager.getConnection(myUrl, "root", "GeorgeKolliosClass660");
            
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
            if (userType.equals("customer")){
                return new Customer(userId, rs.getString("username"), rs.getString("username"), rs.getString("password"));
            } else if (userType.equals("manager")) {
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
                    if (userType.equals("customer")){
                        return new Customer(rs.getInt("user_id"), rs.getString("username"), rs.getString("username"), rs.getString("password"));
                    } else if (userType.equals("manager")) {
                        return new Manager(rs.getInt("user_id"), rs.getString("username"), rs.getString("username"), rs.getString("password"));
                    }
                }
                
            }

        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return null;
        
    }



    public static void main(String[] args) {
        Database db = new Database();
        // db.insertUser("customer", "Mark Zucc", "password");
        User user = db.getUser(1);
        System.out.println(user);
    }
}
