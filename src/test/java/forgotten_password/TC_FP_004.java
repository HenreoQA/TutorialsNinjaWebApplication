package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_004 {

	public static void main(String[] args) {
		
		//Launch the browser
        WebDriver driver = new ChromeDriver();
     // WebDriver driver = new EdgeDriver();
     // WebDriver driver = new FirefoxDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait


	        try {
          // Open the Application URL and navigate to Login Page
	            driver.get("http://tutorialsninja.com/demo");
	            driver.manage().window().maximize(); //maximise the page
	            driver.findElement(By.xpath("//span[@class='caret']")).click();
	            driver.findElement(By.linkText("Login")).click();
	            
	            // Click on 'Forgotten Password' link from Login page
	            driver.findElement(By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']")).click();

	            // Enter the email address of an existing account
	            driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");

	            // Click on 'Continue' button
	            driver.findElement(By.cssSelector("input[type='submit']")).click();

	            // Navigate back to Login Page
	            driver.findElement(By.xpath("//span[@class='caret']")).click();
	            driver.findElement(By.linkText("Login")).click();

	            // Enter the registered email address into the 'E-mail Address' field
	            driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");

	            // Enter the old password into the 'Password' field
	            driver.findElement(By.id("input-password")).sendKeys("Password123");

	            // Click on 'Login' button (ER-1)
	            driver.findElement(By.cssSelector("input[type='submit']")).click();

	            // Verify that the user can log in with the old password
	            
	            if(driver.getTitle().equals("My Account"))
	            {
	                System.out.println("Passed: User was able to log in with the old password before completing the reset process");
	            } 
	            else 
	            {
	                System.out.println("Failed: User was not able to log in with the old password");
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
