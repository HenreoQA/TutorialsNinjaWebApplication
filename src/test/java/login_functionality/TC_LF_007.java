package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_LF_007 
{
	 public static void main(String[] args) 
	    {
	        // Initialize WebDriver
           WebDriver driver = new ChromeDriver();
        // WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();
           
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
      try {
      // Open the Application URL
      driver.get("http://tutorialsninja.com/demo");

      // Maximize the browser window
      driver.manage().window().maximize();

      // Click on 'My Account' Dropmenu
      driver.findElement(By.xpath("//span[@class='caret']")).click();
     
      // Click on 'Login' option
      driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();
      
      // Creating Actions class object for keyboard actions
      Actions actions = new Actions(driver);

      //Enter valid email address using keyboard keys
      driver.findElement(By.id("input-email")).click();
      actions.sendKeys("automationninja@gmail.com").perform();

      // Press Tab to move control to Password text field and enter the valid password
      actions.sendKeys(Keys.TAB).perform();
      actions.sendKeys("Password123").perform();

      // Press Tab until control is on the 'Login' button and press 'Enter' key to submit
      actions.sendKeys(Keys.TAB).perform();
      actions.sendKeys(Keys.TAB).perform();
      actions.sendKeys(Keys.ENTER).perform();

      // Verify the user is navigated to the 'Account' page
      String expectedAccountPageTitle = "My Account";
      String actualAccountPageTitle = driver.getTitle();
       if(expectedAccountPageTitle.equals(actualAccountPageTitle))
       {
    	   System.out.println("User is navigated to Account page");
       }
       else
       {
    	   System.out.println("User is not navigated to Account page");
       }
    }
       catch(Exception e)
       {
    	 e.printStackTrace();
       }

           // Close the browser
             // driver.quit();
     }
  }
