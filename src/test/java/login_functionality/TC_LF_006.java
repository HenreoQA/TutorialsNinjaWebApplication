package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_006 
{
	 public static void main(String[] args) 
	    {
	        // Initialize WebDriver
	          WebDriver driver = new ChromeDriver();
	       // WebDriver driver = new EdgeDriver();
	       // WebDriver driver = new FirefoxDriver();
	          
	          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

	        try {
	            // Open the Application URL
	            driver.get("http://tutorialsninja.com/demo");

	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Click on 'My Account' Dropmenu
	            driver.findElement(By.xpath("//span[@class='caret']")).click();
	           
	            // Click on 'Login' option
	            driver.findElement(By.xpath("//a[text()='Login']")).click();
	            
	            // Verify user is navigated to the Login page
	           String expectedloginpagetitle = "Account Login";
	           String actualloginpagetitle = driver.getTitle();
	           if(expectedloginpagetitle.equals(actualloginpagetitle))
	           {
	        	   System.out.println("User is on the login page");
	           }
	           else 
	           {
	        	 System.out.println("User is not on the login page");   
	           }
	           
	           // Verify 'Forgotten Password' link is displayed
	           WebElement forgottenPasswordLink = driver.findElement(By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']"));
               if(forgottenPasswordLink.isDisplayed())
               {
            	   System.out.println("forgotten password link is displayed");
               }
               else
               {
            	   System.out.println("forgotten password link is not displayed");
               }
               
               // Click on 'Forgotten Password' link
               forgottenPasswordLink.click();
               
               // Verify user is navigated to the 'Forgotten Password' page
               String expectedForgottenPasswordPageTitle = "Forgot Your Password?";
               String actualForgottenPasswordPageTitle = driver.getTitle();
               if(expectedForgottenPasswordPageTitle.equals(actualForgottenPasswordPageTitle))
               {
            	   System.out.println("Test passed:user is on the forgotten password page");
               }
               else
               {
            	   System.out.println("Test failed:user is not on the forgotten password page");
               }
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        
	     // Close the browser
            driver.quit();
               
}

	} 
