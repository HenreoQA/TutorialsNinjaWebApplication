package register_functionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_015A 
{
	public static void main(String[] args) 
	{
	 WebDriver driver=new ChromeDriver(); //Launch chrome browser
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
		
    try {
        // Step 1: Open the application
    	driver.get("http://localhost/opencart/upload/admin/");
        
        driver.manage().window().maximize(); //Maximise the page
        
        //Entering the admin account details
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
        
        //Clicking on customers and add new buttons
        driver.findElement(By.xpath("//li[@id='menu-customer']/a")).click();
        driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
        driver.findElement(By.xpath("//i[@class='fa-solid fa-plus']")).click();

        // Step 4: Enter new account details
        driver.findElement(By.id("input-firstname")).sendKeys("John");
        driver.findElement(By.id("input-lastname")).sendKeys("Mark");
        driver.findElement(By.id("input-email")).sendKeys("john_m@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("0123456789");
        driver.findElement(By.id("input-password")).sendKeys("password123");
        driver.findElement(By.id("input-confirm")).sendKeys("password123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Verify the details in the database
        verifyDatabase("John", "Mark", "john_m@gmail.com");

    } 
    finally 
    {
        // Close the browser
        driver.quit();
    }
}

public static void verifyDatabase(String firstName, String lastName, String email) 
{
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
        String query = "SELECT * FROM oc_customer WHERE email = 'john_m@gmail.com'";
        resultSet = statement.executeQuery(query);

        // Verify the user details
        if (resultSet.next()) 
        {
            String FirstName = resultSet.getString("firstname");
            String LastName = resultSet.getString("lastname");
            String Email = resultSet.getString("email");

            if ("John".equals(FirstName) && "Mark".equals(LastName) && "john_m@gmail.com".equals(Email)) 
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
