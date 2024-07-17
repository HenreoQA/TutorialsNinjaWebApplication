package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_001
{
    public static void main(String[] args) 
    {
        // Initialize WebDriver
          WebDriver driver = new ChromeDriver();
       // WebDriver driver = new EdgeDriver();
       // WebDriver driver = new FirefoxDriver();
          
            //Set implicit wait time
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        
          try {
            // Open the Application URL
            driver.get("http://tutorialsninja.com/demo");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Click on 'My Account' Dropmenu
            driver.findElement(By.xpath("//span[@class='caret']")).click();
           
            // Click on 'Login' option
            driver.findElement(By.xpath("//a[text()='Login']")).click();

            // Enter valid email address into the 'E-Mail Address' field
            driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");

            // Enter valid password into the 'Password' field
           driver.findElement(By.id("input-password")).sendKeys("Password123");

            // Click on 'Login' button
            driver.findElement(By.xpath("//input[@value='Login']")).click();

            // Verify user is navigated to the 'Account' page
            WebElement accountPageHeader = driver.findElement(By.xpath("//h2[text()='My Account']"));
            if (accountPageHeader.isDisplayed()) 
            {
                System.out.println("User is successfully logged in and navigated to the 'Account' page.");
            } 
            else 
            {
                System.out.println("User login failed.");
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


