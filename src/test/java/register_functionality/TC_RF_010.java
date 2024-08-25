package register_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class TC_RF_010
{

    public static void main(String[] args) 
    {
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
        //WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

        // Open the Application
        driver.get("http://tutorialsninja.com/demo");

        // Maximize the browser window
        driver.manage().window().maximize();

        // List of invalid email addresses to test - storing the values in one variable using array
        List<String> invalidEmails = Arrays.asList("henry", "henry@", "henry@gmail", "henry@gmail.");

        for (String invalidEmail : invalidEmails)  //use enhanced for loop to execute the statement multiple times
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
	        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Henry");

	        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Agulanna");
	        
	        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
            email.sendKeys(invalidEmail);
 
            driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("1234567890");
	        
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
            
            driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("12345");

            driver.findElement(By.xpath("//input[@name='agree']")).click();

	        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    

            // Expected Result: Verify the warning message for invalid email address
            try 
            {
                WebElement warningMessage = driver.findElement(By.xpath("//div[@class='text-danger']"));
                if (warningMessage.getText().contains("E-Mail Address does not appear to be valid!")) 
                {
                    System.out.println("Test Passed: Proper warning message for invalid email '" + invalidEmail + "' is displayed.");
                }
                else 
                {
                    System.out.println("Test Failed: Proper warning message for invalid email '" + invalidEmail + "' is not displayed.");
                }
            } 
            catch (Exception e) 
            {
                System.out.println("Warning message for invalid email '" + invalidEmail + "' is displayed in another format.");
            }
        }

        // Close the browser
        driver.quit();
    }
}

