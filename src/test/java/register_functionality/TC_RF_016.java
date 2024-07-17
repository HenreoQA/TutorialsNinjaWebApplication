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

      public class TC_RF_016
 {

      public static void main(String[] args) 
   {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();

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

        // Test Step 3: Enter spaces into the Mandatory Fields
        driver.findElement(By.id("input-firstname")).sendKeys(" ");
        driver.findElement(By.id("input-lastname")).sendKeys(" ");
        driver.findElement(By.id("input-email")).sendKeys(" ");
        driver.findElement(By.id("input-telephone")).sendKeys(" ");
        driver.findElement(By.id("input-password")).sendKeys(" ");
        driver.findElement(By.id("input-confirm")).sendKeys(" ");
        driver.findElement(By.name("agree")).click();

        // Test Step 4: Click on 'Continue' button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Verification: Check for warning messages

        // List of field IDs to check for warning messages
        String[] fieldIds = {"input-firstname", "input-lastname", "input-email", "input-telephone", "input-password", "input-confirm"};

        for (String fieldId : fieldIds) 
        {
            try {
                WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='" + fieldId + "']/following-sibling::div")));
                if (warningMessage.isDisplayed()) 
                {
                   
                    System.out.println("Warning message displayed for field: " + fieldId);
                }
            } 
            catch (Exception e) 
            {
                System.out.println("No warning message displayed for field: " + fieldId);
            }
        }

      
        // Close the browser
       // driver.quit();
    }
}

