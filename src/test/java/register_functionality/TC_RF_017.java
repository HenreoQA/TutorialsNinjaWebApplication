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

public class TC_RF_017 
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

        // Test Step 3: Enter new Account Details into all the Mandatory Fields except Password and Confirm Password
        driver.findElement(By.id("input-firstname")).sendKeys("Henry");
        driver.findElement(By.id("input-lastname")).sendKeys("Mike");
        String email = "testuser" + System.currentTimeMillis() + "@gmail.com"; // Generate random email
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys("1234567890");

        // Test Step 4: Check entering simple passwords that do not follow the complexity standards
        driver.findElement(By.id("input-password")).sendKeys("12345");
        driver.findElement(By.id("input-confirm")).sendKeys("12345");

        // Click the Privacy Policy checkbox
        driver.findElement(By.name("agree")).click();

        // Test Step 5: Click on 'Continue' button
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        // Expected Result: Warning message should be displayed for not following Password Complexity Standards
        boolean isWarningDisplayed = checkPasswordComplexityWarning(driver);

        // Verification
        if(isWarningDisplayed) 
        {
            System.out.println("Test Passed: Warning message is displayed for not following password complexity standards.");
        } 
        else 
        {
            System.out.println("Test Failed: No warning message for password complexity.");
        }

        // Close the browser
        driver.quit();
    }

    private static boolean checkPasswordComplexityWarning(WebDriver driver) {
        try {
            WebElement passwordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div[contains(text(), 'Password must be between 4 and 20 characters!')]"));
            return passwordWarning.isDisplayed();
            } 
        catch (Exception e) 
        {
            return false;
        }
    }
}
