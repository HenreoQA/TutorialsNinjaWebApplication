package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC_LF_020 
{
    public static void main(String[] args) 
    {
        // Initialize the ChromeDriver
          WebDriver driver = new ChromeDriver();
       // WebDriver driver = new EdgeDriver();
        //WebDriver driver = new FirefoxDriver();
          
        // Set the implicit wait time
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            try {
            // Maximize the browser window
            driver.manage().window().maximize();
            
             // Open the application
            driver.get("http://tutorialsninja.com/demo");

            // Way 1: Click on 'Login page' link in the 'Register Account' page
            WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
            myAccountDropMenu.click();
            WebElement registerOption = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
            registerOption.click();
            WebElement loginPageLink = driver.findElement(By.xpath("//a[normalize-space()='login page']"));
            loginPageLink.click();
            verifyLoginPage(driver, "Way 1");

            // Navigate back to the homepage
            driver.navigate().back();
            driver.navigate().back();

            // Way 2: Select 'Login' option from the 'My Account' Dropmenu
            myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
            myAccountDropMenu.click();
            WebElement loginOption = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
            loginOption.click();
            verifyLoginPage(driver, "Way 2");
            
         // Way 3: Click on 'Login' option from the 'Right Column' options
            WebElement loginRightColumn = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Login']"));
            loginRightColumn.click();
            verifyLoginPage(driver, "Way 3");
         } 
            catch(Exception e)
            {
              e.printStackTrace();
            }
            finally 
            {
                // Close browser
               driver.quit();
            }
        }
   
    private static void verifyLoginPage(WebDriver driver, String way) 
    {
        // Verify that the title of the page contains 'Account Login'
        if (driver.getTitle().contains("Account Login")) 
        {
            System.out.println(way + ": Navigated to Login page successfully.");
        } 
        else 
        {
            System.out.println(way + ": Failed to navigate to Login page.");
        }
        
    }
  
 }

