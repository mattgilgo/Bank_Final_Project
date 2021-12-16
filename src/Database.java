import java.sql.*;


public class Database {
    
    Connection conn;
    
    public Database(){
        getConnection();
        
        
    }

    private void getConnection(){
        try
            {
            String myUrl = "jdbc:sqlite:C:/Users/GeorgeE/Documents/BU/CS_611/final_project/Bank_Final_Project/Bank.db";
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
            if (userType.equals("C")){
                return new Customer(userId, rs.getString("username"), rs.getString("username"), rs.getString("password"));
            } else if (userType.equals("M")) {
                return new Manager(userId, rs.getString("username"), rs.getString("username"), rs.getString("password"));
            }

        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return null;
        
    }

    public void test(){
        String sql = "SELECT * FROM users";
        
        try (
            PreparedStatement pstmt  = conn.prepareStatement(sql)){
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            while(rs.next()) {
                System.out.println(rs.getString("username"));
            }
            
    
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        
        
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
                    if (userType.equals("C")){
                        return new Customer(rs.getInt("user_id"), rs.getString("user_type"), rs.getString("username"), rs.getString("password"));
                    } else if (userType.equals("M")) {
                        return new Manager(rs.getInt("user_id"), rs.getString("user_type"), rs.getString("username"), rs.getString("password"));
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
        db.test();
        db.insertUser("C", "Mark Zucc", "password");
        User user = db.getUser(1);
        System.out.println(user);
        User loginCheck = db.checkLogin("Mark Zucc", "password");
        System.out.println(loginCheck);
    }
}
