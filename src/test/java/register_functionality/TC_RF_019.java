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

public class TC_RF_019
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

        // Test Step 3: Enter new Account Details into all the Fields with leading and trailing spaces
        String email = " testuser" + System.currentTimeMillis() + "@gmail.com "; // Generate unique email with spaces
        driver.findElement(By.id("input-firstname")).sendKeys(" John ");
        driver.findElement(By.id("input-lastname")).sendKeys(" Frank ");
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(" 1234567890 ");
        driver.findElement(By.id("input-password")).sendKeys(" Test1234 ");
        driver.findElement(By.id("input-confirm")).sendKeys(" Test1234 ");
        driver.findElement(By.name("agree")).click();

        // Test Step 4: Click on 'Continue' button
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        // Expected Result: Verify that the leading and trailing spaces are trimmed
        try {
            // Wait until the success message is displayed
            driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
            System.out.println("Account creation successful. Now verifying trimmed values.");

            // Navigating to account details page to verify trimmed values
            WebElement accountDropdown = driver.findElement(By.xpath("//span[@class='caret']"));
            accountDropdown.click();
            
            WebElement account = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='My Account']"));
            account.click();

            // Verify that the values are trimmed
            verifyTrimmedValues(driver, "input-firstname", "John");
            verifyTrimmedValues(driver, "input-lastname", "Frank");
            verifyTrimmedValues(driver, "input-email", "testuser" + System.currentTimeMillis() + "@gmail.com"); // The email without spaces
            verifyTrimmedValues(driver, "input-telephone", "1234567890");
        } 
        catch (Exception e) 
        {
            System.out.println("Account creation failed or leading/trailing spaces were not trimmed.");
        }

        // Close the browser
        driver.quit();
    }

    private static void verifyTrimmedValues(WebDriver driver, String fieldId, String expectedValue) 
    {
        WebElement field = driver.findElement(By.id(fieldId));
        String actualValue = field.getAttribute("value");
        if (actualValue.equals(expectedValue)) 
        {
            System.out.println("Field " + fieldId + " is correctly trimmed.");
        } 
        else 
        {
            System.out.println("Field " + fieldId + " is not trimmed correctly. Expected: " + expectedValue + ", but got: " + actualValue);
        }
    }
}
