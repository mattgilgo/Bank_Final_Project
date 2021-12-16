import java.sql.*;


/**
 * A Java MySQL PreparedStatement INSERT example.
 * Demonstrates the use of a SQL INSERT statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 * 
 * Created by Alvin Alexander, http://alvinalexander.com
 */
public class JavaMysqlPreparedStatementInsertExample
{

  public static void main(String[] args)
  {
    try
    {
      // create a mysql database connection
      
      //Properties props = new Properties();
      //props.load(new FileInputStream("bank.properties"));
      
      String myDriver = "com.mysql.cj.jdbc.Driver";
      Class.forName(myDriver);
      String myUrl = "jdbc:mysql://localhost:3306/bank";
      Connection conn = DriverManager.getConnection(myUrl, "root", "GeorgeKolliosClass660");
    
      // create a sql date object so we can use it in our INSERT statement
      //Calendar calendar = Calendar.getInstance();
      //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

      // the mysql insert statement
      String query = " insert into customer (name, balance, username, password)"
        + " values (?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString(1, "Mark Zuccc");
      preparedStmt.setString(2, "10000000000");
      preparedStmt.setString(3, "smokinmeats");
      preparedStmt.setString(4, "meta");

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
  }
}