package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_013 {

	public static void main(String[] args) {
		
		 // Initialize WebDriver
            WebDriver driver = new ChromeDriver();
         //WebDriver driver = new EdgeDriver();
         //WebDriver driver = new FirefoxDriver();
        
          //Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
      
        try {
          // Open the Application URL
          driver.get("http://tutorialsninja.com/demo");

          // Maximize the browser window
          driver.manage().window().maximize();

          // Click on 'My Account' Dropmenu
          driver.findElement(By.xpath("//span[@class='caret']")).click();
         
          // Click on 'Login' option
          driver.findElement(By.xpath("//a[text()='Login']")).click();
          
          //Enter any text into the 'Password' field
          WebElement passwordField = driver.findElement(By.id("input-password"));
          passwordField.sendKeys("Password123");
          
          // Expected Result: Password text entered into 'Password' field needs to be toggled to hide its visibility
          String passwordFieldType = passwordField.getAttribute("type");
         
          if (passwordFieldType.equals("password")) 
          {
              System.out.println("Test Passed: Password text is hidden in 'Password' field..");
          } 
          else 
          {
              System.out.println("Test Failed: Password text is not hidden in password fields..");
          }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        finally
        {
        	//Close browser
        	driver.quit();
        }


	}

}
