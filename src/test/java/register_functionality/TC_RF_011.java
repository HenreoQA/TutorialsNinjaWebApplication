package register_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class TC_RF_011
  {

    public static void main(String[] args) throws IOException {
        
        // Initialize WebDriver
          WebDriver driver = new ChromeDriver();
       // WebDriver driver = new EdgeDriver();
       //  WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait

        // Open the Application
        driver.get("http://tutorialsninja.com/demo");

        // Maximize the browser window
        driver.manage().window().maximize();
        
        
        // List of invalid phone numbers to test
        List<String> invalidPhones = Arrays.asList("111", "abcde");

        for (String invalidPhone : invalidPhones) 
         {
            // Refresh the application page before each test
            driver.navigate().refresh();

            // Test Step 1: Click on 'My Account' Drop menu
            WebElement myAccount = driver.findElement(By.xpath("//span[@class='caret']"));
	        myAccount.click();

            // Test Step 2: Click on 'Register' option
	        WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
	        register.click();


            // Test Step 3: Enter new Account Details into all the Fields and click on continue button
            WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
            firstName.sendKeys("Mike");

            WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
            lastName.sendKeys("Tom");

            WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
            email.sendKeys("miky44.Tom@yahoo.com");

            WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
            telephone.sendKeys(invalidPhone);

            WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
            password.sendKeys("Test12345");

            WebElement passwordConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
            passwordConfirm.sendKeys("Test12345");

            WebElement privacyPolicy = driver.findElement(By.xpath("//input[@name='agree']"));
            privacyPolicy.click();

            WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
            continueButton.click();

            // Expected Result: Verify the warning message for invalid phone number
            try 
            {
                WebElement warningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-danger')]"));
                if (warningMessage.getText().contains("Telephone must be between 3 and 32 characters!")) 
                {
                    System.out.println("Test Passed: Proper warning message for invalid phone number '" + invalidPhone + "' is displayed.");
                } 
                else 
                {
                    System.out.println("Test Failed: Proper warning message for invalid phone number '" + invalidPhone + "' is not displayed.");
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Test Failed: Warning message for invalid phone number '" + invalidPhone + "' is not displayed.");
            }
        }

        // Close the browser
        driver.quit();
    }
}
