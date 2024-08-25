package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_003 {

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
	            
	            // Enter the registered email address into the 'E-Mail address' field
	            driver.findElement(By.id("input-email")).sendKeys("automationninja82@gmail.com");

	            // Enter the old password into the 'Password' field
	            driver.findElement(By.id("input-password")).sendKeys("oldpassword1234");

	            // Click on 'Login' button (Verify ER-1)
	            driver.findElement(By.xpath("//input[@value='Login']")).click();

	            // Verify that the user cannot log in with the old password
	            WebElement loginErrorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
	            if (loginErrorMessage.isDisplayed() && loginErrorMessage.getText().contains("Warning: No match for E-Mail Address and/or Password.")) 
	            {
	                System.out.println("Passed: User cannot log in with the old password");
	            } 
	            else 
	            {
	                System.out.println("Failed: User was able to log in with the old password");
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
