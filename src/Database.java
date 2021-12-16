import java.sql.*;


public class Database {
    
    private String myDriver = "com.mysql.cj.jdbc.Driver";
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

    public void getUser(int userId){
        String sql = "SELECT user_type, username, password FROM users WHERE user_id = ?";
        
        try (
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            
            // set the value
            pstmt.setInt(1,userId);
            //
            ResultSet rs  = pstmt.executeQuery();
            
            // loop through the result set
            String password = rs.getString("username");
            String password = rs.getString("username");
            String password = rs.getString("password");

            while (rs.next()) {
                System.out.println(rs.getString("user_type") +  "\t" + 
                                   rs.getString("username") + "\t" +
                                   rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {
        Database db = new Database();
        // db.insertUser("customer", "Mark Zucc", "password");
        db.getUser(1);
    }
}
