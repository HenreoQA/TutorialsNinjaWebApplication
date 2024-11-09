package register_functionality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_015B {

	public static void main(String[] args) throws InterruptedException{
		
		 WebDriver driver=new ChromeDriver(); //Launch chrome browser
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
			
	   try {
	        // Step 1: Open the application
	    	driver.get("http://localhost/opencart/upload/");
	        
	        driver.manage().window().maximize(); //Maximise the page
	        
	        //Click on My Account drop menu
	        driver.findElement(By.xpath("//span[text()='My Account']")).click();
	        
	        //Click on Register
	        driver.findElement(By.xpath("//a[text()='Register']")).click();
	        
	        //Enter account details into the fields
	        driver.findElement(By.id("input-firstname")).sendKeys("James");
	        driver.findElement(By.id("input-lastname")).sendKeys("Fred");
	        driver.findElement(By.id("input-email")).sendKeys("james_fred@yahoo.com");
	        driver.findElement(By.id("input-password")).sendKeys("12345");
	        driver.findElement(By.id("input-newsletter")).click(); //Newsletter
	        
	        WebElement privacy = driver.findElement(By.name("agree")); //Privacy policy
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", privacy);
	        
	        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button); //Continue button

	        
	        // Verify the details in the database
	        verifyDatabase("James", "Fred", "james_fred@yahoo.com");

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

	        // Create statement to send SQL statement to the database
	        statement = connection.createStatement();

	        // Execute query to check the registered customer details
	         String query = "SELECT * FROM oc_customer WHERE email = 'james_fred@yahoo.com'";
	        resultSet = statement.executeQuery(query);

	        // Verify the user details
	        if (resultSet.next())  // itereate over the rows in a resultset or Checks if there is at least one row
	        {
	            String FirstName = resultSet.getString("firstname");
	            String LastName = resultSet.getString("lastname");
	            String Email = resultSet.getString("email");

	            if ("James".equals(FirstName) && "Fred".equals(LastName) && "james_fred@yahoo.com".equals(Email)) 
	            {
	                System.out.println("Account details successfully stored in the database");
	            } 
	            else 
	            {
	                System.out.println("Account details do not match");
	            }
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
