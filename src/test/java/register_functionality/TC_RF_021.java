package register_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_RF_021
{

    public static void main(String[] args) 
    {
       
        // Initialize WebDriver
          WebDriver driver = new ChromeDriver();
       // WebDriver driver = new EdgeDriver();
         //WebDriver driver = new FirefoxDriver();

        // Open the Application
        driver.get("http://tutorialsninja.com/demo");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Test Step 1: Click on 'My Account' Drop menu
        WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='caret']")));
        myAccount.click();
        
        // Test Step 2: Click on 'Register' option
        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']")));
        register.click();


        // Test Step 3: Enter new Account Details into all the Fields
        driver.findElement(By.id("input-firstname")).sendKeys("Kennedy");
        driver.findElement(By.id("input-lastname")).sendKeys("Leo");
        driver.findElement(By.id("input-email")).sendKeys("kenleo" + System.currentTimeMillis() + "@gmail.com"); // Generate unique email
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
        driver.findElement(By.id("input-password")).sendKeys("Password123");
        driver.findElement(By.id("input-confirm")).sendKeys("Password123");

        // Don't select the 'Privacy Policy' checkbox option

        // Test Step 4: Click on 'Continue' button
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        // Expected Result: Warning message - 'Warning: You must agree to the Privacy Policy!' should be displayed
        try {
            WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));
            if (warningMessage.isDisplayed()) 
            {
                System.out.println("Test Passed: 'Warning: You must agree to the Privacy Policy!' message is displayed.");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Test Failed: Warning message not displayed.");
        }

        // Close the browser
        driver.quit();
    }
}

