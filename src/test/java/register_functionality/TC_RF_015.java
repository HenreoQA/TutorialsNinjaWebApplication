package register_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;

public class TC_RF_015
{

    public static void main(String[] args) 
    { 
        // Initialize WebDriver
            WebDriver driver = new ChromeDriver();
        //  WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

        // Open the application URL
         driver.get("https://demo.opencart.com/");
        
        
        // Maximise the page
        
        driver.manage().window().maximize();
        
        // Click on 'My Account' Drop menu
        WebElement myAccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
        myAccount.click();

        // Click on 'Register' option
        WebElement register = driver.findElement(By.linkText("Register"));
        register.click();

        // Enter new Account Details
        driver.findElement(By.id("input-firstname")).sendKeys("Hilary");
        driver.findElement(By.id("input-lastname")).sendKeys("Joe");
        driver.findElement(By.id("input-email")).sendKeys("hiljoe@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("password123");

        // Select the Privacy Policy checkbox
        WebElement privacyPolicy = driver.findElement(By.name("agree"));
        privacyPolicy.click();

        // Click on 'Continue' button
        WebElement continueButton = driver.findElement(By.xpath("//button[@type='submit']"));
        continueButton.click();

        // Verify account registration success
        String expectedMessage = "Your Account Has Been Created!";
        WebElement successMessage = driver.findElement(By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]"));
        if (successMessage.getText().equals(expectedMessage)) 
        {
            System.out.println("Account registration successful...");
        } 
        else 
        {
            System.out.println("Account registration failed...");
        }

        // Close the browser
        driver.quit();

        // Verify the details in the database
        String jdbcUrl = "jdbc:mysql://localhost:3306/";
        String dbName = "opencart";
        String username = "root";
        String password = "root";
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
            String query = "SELECT * FROM Customers WHERE email = 'hiljoe@gmail.com'";
            resultSet = statement.executeQuery(query);

            // Verify the user details
            if (resultSet.next()) 
            {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String email = resultSet.getString("email");

                if ("Hilary".equals(firstName) && "Joe".equals(lastName) && "hiljoe@gmail.com".equals(email)) 
                {
                    System.out.println("Account details successfully stored in the database.");
                } 
                else 
                {
                    System.out.println("Account details do not match.");
                }
            } 
            else
            {
                System.out.println("No account found with the given email.");
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
