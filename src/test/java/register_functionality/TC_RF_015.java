package register_functionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TC_RF_015
{

    public static void main(String[] args) 
    { 
  
       // Verify the details in the database
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String dbName = "opencart";
        String username = "root";
        String password =null;
        Connection connection = null; //global connection
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            connection = DriverManager.getConnection(jdbcUrl+dbName, username, password);

            // Create statement
            statement = connection.createStatement();

            // Execute query to check the registered customer details
            String query = "SELECT * FROM oc_customer WHERE email = 'matj@yahoo.com'";
            resultSet = statement.executeQuery(query);

            // Verify the user details
            if (resultSet.next()) 
            {
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String email = resultSet.getString("email");

                if ("Matthew".equals(firstName) && "John".equals(lastName) && "matj@yahoo.com".equals(email)) 
                {
                    System.out.println("Account details successfully stored in the database");
                } 
                else 
                {
                    System.out.println("Account details do not match");
                }
            } 
            else
            {
                System.out.println("No account found with the given email");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
    }
}
