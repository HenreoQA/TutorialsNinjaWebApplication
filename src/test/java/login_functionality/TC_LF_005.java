package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_005 
{
	public static void main(String[] args) 
    {
        // Initialize WebDriver
         WebDriver driver = new ChromeDriver();
       //WebDriver driver = new EdgeDriver();
       //WebDriver driver = new FirefoxDriver();
          
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

        try {
            // Open the Application URL
            driver.get("http://tutorialsninja.com/demo");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Click on 'My Account' Dropmenu
            driver.findElement(By.xpath("//span[@class='caret']")).click();
           
            // Click on 'Login' option
            driver.findElement(By.xpath("//a[text()='Login']")).click();

            // Don't enter anything into the 'E-Mail Address' field
            driver.findElement(By.id("input-email")).clear();

            // Don't enter anything into the 'Password' field
           driver.findElement(By.id("input-password")).clear();

            // Click on 'Login' button
            driver.findElement(By.xpath("//input[@value='Login']")).click();

            // Verify the warning message
            WebElement warningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
            String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
            String actualMessage = warningMessage.getText();
            if (actualMessage.contains(expectedMessage)) 
            {
                System.out.println("Test Passed: Warning message is displayed correctly.");
            } 
            else 
            {
                System.out.println("Test Failed: Warning message is incorrect.");
                System.out.println("Actual Message: " + actualMessage);
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
            
        // Close the browser
            driver.quit();
        }
}
