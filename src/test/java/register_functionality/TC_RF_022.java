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

public class TC_RF_022 {

    public static void main(String[] args) {
      
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

        // Test Step 3: Enter some Password text into the 'Password' and 'Password Confirm' fields
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password")));
        WebElement confirmPasswordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-confirm")));
        
        String password = "Password123";
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);

        // Expected Result: Password text entered into 'Password' and 'Password Confirm' fields need to be toggled to hide its visibility
        String passwordFieldType = passwordField.getAttribute("type");
        String confirmPasswordFieldType = confirmPasswordField.getAttribute("type");

        if ("password".equals(passwordFieldType) && "password".equals(confirmPasswordFieldType)) 
        {
            System.out.println("Test Passed: Password text is hidden in both 'Password' and 'Password Confirm' fields.");
        } 
        else 
        {
            System.out.println("Test Failed: Password text is not hidden in one or both fields.");
        }

        // Close the browser
        driver.quit();
    }
}

