package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC_LF_008 
 {
    public static void main(String[] args) 
    {
    	 // Initialize WebDriver
         WebDriver driver = new ChromeDriver();
      // WebDriver driver = new EdgeDriver();
     // WebDriver driver = new FirefoxDriver();
        
            // Set the implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
               // Open the application
            driver.get("http://tutorialsninja.com/demo");
            
              // Maximize the browser window
            driver.manage().window().maximize();

            // Click on 'My Account' drop menu
            driver.findElement(By.xpath("//span[@class='caret']")).click();
            
            // Click on 'Login' option
            driver.findElement(By.xpath("//a[text()='Login']")).click();
           
           // Locate the 'E-Mail Address' and 'Password' text fields
            WebElement emailField = driver.findElement(By.id("input-email"));
            WebElement passwordField = driver.findElement(By.id("input-password"));

            // Get the placeholder attribute values
            String emailPlaceholder = emailField.getAttribute("placeholder");
            String passwordPlaceholder = passwordField.getAttribute("placeholder");

            // Verify the placeholder texts
            if ("E-Mail Address".equals(emailPlaceholder) && "Password".equals(passwordPlaceholder)) 
            {
                System.out.println("Test Passed: Proper placeholder text is displayed.");
            } 
            else 
            {
                System.out.println("Test Failed: Placeholder text is incorrect.");
                System.out.println("E-Mail Address placeholder: " + emailPlaceholder);
                System.out.println("Password placeholder: " + passwordPlaceholder);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
         finally 
            {
              // Close the browser
               driver.quit();
            }
    }
}

