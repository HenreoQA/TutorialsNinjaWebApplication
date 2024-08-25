package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_007 {

	public static void main(String[] args) {
		
		//Launch the browser
        WebDriver driver = new ChromeDriver();
     // WebDriver driver = new EdgeDriver();
     // WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

        try {
            // Step 1: Open the Application URL and navigate to the Login Page
            driver.get("http://tutorialsninja.com/demo");
            driver.manage().window().maximize(); //maximise the page
            driver.findElement(By.xpath("//span[@class='caret']")).click();
            driver.findElement(By.linkText("Login")).click();

            // Step 2: Click on 'Forgotten Password' link from the Login page
            driver.findElement(By.linkText("Forgotten Password")).click();

            // Step 3: Enter the email address of an existing account
            driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");

            // Step 4: Click on 'Continue' button to request password reset
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            
            //Let's assume the reset link is something like this:
            String resetLink = "http://tutorialsninja.com/demo/index.php?route=account/reset&code=abc123";

            // Step 5: Click on the link for resetting the password from the received email body
            driver.get(resetLink);

            // Step 6: Enter a password into the 'Password' field
            driver.findElement(By.id("input-password")).sendKeys("test234");

            // Step 7: Enter a different password into the 'Confirm' field
            driver.findElement(By.id("input-confirm")).sendKeys("24689");

            // Step 8: Click on 'Continue' button
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Verify the field-level warning message under 'Confirm' field
            WebElement errorMessage = driver.findElement(By.cssSelector(".text-danger"));
            if (errorMessage.isDisplayed() && errorMessage.getText().contains("Password and password confirmation do not match!")) 
            {
                System.out.println("Test passed: Warning message displayed correctly");
            } 
            else 
            {
                System.out.println("Test failed: Warning message not displayed");
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            // Close the browser
            driver.quit();
        }

	}

}
