package forgotten_password;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

	  public class TC_FP_005 {

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
	            driver.findElement(By.linkText("Forgotten Password")).click();

	            // Enter an email address for which the Account doesn't exist in the application
	            driver.findElement(By.id("input-email")).sendKeys("ngo1234@yahoo.com");

	            //  Click on 'Continue' button
	            driver.findElement(By.cssSelector("input[type='submit']")).click();

	            // Verify that the success message is displayed
	            WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
	            if (successMessage.isDisplayed() && successMessage.getText().contains("An email with a confirmation link has been sent your email address.")) 
	            {
	            	
	                System.out.println("Test passed: Success message is displayed for non-registered account");
	            } 
	            else 
	            {
	                System.out.println("Test failed: Success message is not displayed");
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


