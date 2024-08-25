package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_006 {

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

            // Step 5: Fetch the reset link from the email
            String resetLink = "URL_FROM_EMAIL"; 

            // Step 6: Use the reset link for the first time
            driver.get(resetLink);
            resetPassword(driver, "1234567");
            
            // Step 7: Attempt to use the same reset link again
            driver.get(resetLink);
            resetPassword(driver, "123456");
            
            //Step 8: Verify that the second attempt fails
            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
            if (errorMessage.isDisplayed() && errorMessage.getText().contains("Password reset code is invalid or was used previously!")) 
            {
                System.out.println("Test Passed:Reset link cannot be used more than once");
            } 
            else 
            {
                System.out.println("Test Failed:Reset link was used more than once");
            }

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            // Close the browser
            driver.quit();
        }
    }

    //Method to reset password
   private static void resetPassword(WebDriver driver, String newPassword) 
    {
        //Enter new password into the 'Password' and 'Confirm' fields
        driver.findElement(By.id("input-password")).sendKeys(newPassword);
        driver.findElement(By.id("input-confirm")).sendKeys(newPassword);

        //Click on 'Continue' button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

   
}
