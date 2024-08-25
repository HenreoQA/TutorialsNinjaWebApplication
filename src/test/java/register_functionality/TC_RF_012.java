package register_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_RF_012
 {

      public static void main(String[] args) 
      {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

        // Open the Application
        driver.get("http://tutorialsninja.com/demo");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Test Step 1: Click on 'My Account' Drop menu
        WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
        myAccountDropMenu.click();

        // Test Step 2: Click on 'Register' option
        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        // Creating Actions class to initialize Actions for keyboard interaction
        Actions actions = new Actions(driver);

        // Test Step 3: Enter new Account Details using keyboard keys
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        firstName.click();
        actions.sendKeys("Michael").sendKeys(Keys.TAB)
        .sendKeys("Rice").sendKeys(Keys.TAB)
        .sendKeys("rice3.mike@gmail.com").sendKeys(Keys.TAB)
        .sendKeys("1234567890").sendKeys(Keys.TAB)
        .sendKeys("test12345").sendKeys(Keys.TAB)
        .sendKeys("test12345").sendKeys(Keys.TAB)
        .sendKeys(Keys.TAB).sendKeys(Keys.TAB) 
        .sendKeys(Keys.SPACE) // For Privacy Policy
        .perform();

        // Test Step 4: Click on 'Continue' button using Enter key
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.sendKeys(Keys.ENTER);

        // Expected Result: Verify user is taken to 'Account Success' page
        try {
            WebElement accountSuccess = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
            if (accountSuccess.isDisplayed()) 
            {
                System.out.println("Test Passed: User is taken to 'Account Success' page.");
            } 
            else 
            {
                System.out.println("Test Failed: User is not taken to 'Account Success' page.");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Test Failed: 'Account Success' page not displayed.");
        }

        // Close the browser
        driver.quit();
    }
}

