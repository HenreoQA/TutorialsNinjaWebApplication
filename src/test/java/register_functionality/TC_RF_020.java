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

public class TC_RF_020
{

    public static void main(String[] args) 
    {
         // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
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

        // Test Step 3: View the 'Privacy Policy' checkbox option
        WebElement privacyPolicyCheckbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("agree")));

        // Expected Result: 'Privacy Policy' checkbox option is not selected by default
        if (!privacyPolicyCheckbox.isSelected()) 
        {
            System.out.println("Test Passed: 'Privacy Policy' checkbox is not selected by default.");
        } 
        else 
        {
            System.out.println("Test Failed: 'Privacy Policy' checkbox is selected by default.");
        }

        // Close the browser
        driver.quit();
    }
}

