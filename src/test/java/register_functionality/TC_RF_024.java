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

public class TC_RF_024
{

    public static void main(String[] args) {
       

        // Initialize WebDriver
           WebDriver driver = new ChromeDriver();
        // WebDriver driver = new EdgeDriver();
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


            // Test Step 3: Enter new Account Details into all the Fields
            WebElement firstNameField = driver.findElement(By.id("input-firstname"));
            WebElement lastNameField = driver.findElement(By.id("input-lastname"));
            WebElement emailField = driver.findElement(By.id("input-email"));
            WebElement telephoneField = driver.findElement(By.id("input-telephone"));
            WebElement passwordField = driver.findElement(By.id("input-password"));
            WebElement privacyPolicyCheckbox = driver.findElement(By.name("agree"));

            firstNameField.sendKeys("Luke");
            lastNameField.sendKeys("Timothy");
            emailField.sendKeys("luke.tim@gmail.com");
            telephoneField.sendKeys("1234567890");
            passwordField.sendKeys("Test123");
            privacyPolicyCheckbox.click();

            // Test Step 4: Don't enter any value into 'Password Confirm' field

            // Test Step 5: Click on 'Continue' button
            WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
            continueButton.click();

            // Expected Result: Warning message - 'Password confirmation does not match password!' should be displayed
            WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-danger']")));
            if (warningMessage.getText().contains("Password confirmation does not match password!")) 
            {
                System.out.println("Test Passed: Correct warning message is displayed.");
            } 
            else 
            {
                System.out.println("Test Failed: Correct warning message is not displayed.");
            }
         
        
            // Close the browser
           driver.quit();
        
    }
}

