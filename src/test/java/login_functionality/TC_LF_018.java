package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_018 {

	public static void main(String[] args) {
		
		 // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
      //WebDriver driver = new EdgeDriver();
     // WebDriver driver = new FirefoxDriver();
        
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

          // Enter valid email address into the 'E-Mail Address' field
          driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");

          // Enter valid password into the 'Password' field
         driver.findElement(By.id("input-password")).sendKeys("Password123");

          // Click on 'Login' button
          driver.findElement(By.xpath("//input[@value='Login']")).click();
          
          // Verify user is navigated to the 'Account' page
          WebElement accountPageHeader = driver.findElement(By.xpath("//h2[text()='My Account']"));
          if (accountPageHeader.isDisplayed()) 
          {
              System.out.println("User is successfully logged in and navigated to the 'Account' page.");
          } 
          else 
          {
              System.out.println("User login failed.");
          }

          //Wait for more than 30 minutes
          try {
              // Wait for 31 minutes
              Thread.sleep(31 * 60 * 1000);
          } 
          catch (InterruptedException e) 
          {
              e.printStackTrace();
          }

          //Perform an action on the application to check for session timeout
          driver.navigate().refresh();

          // Expected result: User should get automatically logged out with a proper message stating your session got expired.
        /*  WebElement loginPageHeader = driver.findElement(By.xpath("//h2[text()='Returning Customer']"));
          if (loginPageHeader.isDisplayed()) 
          {
              System.out.println("User session has expired. Proper message displayed.");
          } 
          else 
          {
              System.out.println("User session has not expired as expected.");
          }*/
          
          if(driver.getTitle().equals("My Account"))
          {
        	  System.out.println("Test fail:User session has not expired as expected.");
          }
          else
          {
        	  System.out.println("Test pass:User session has expired");
          }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
          //Close browser
            driver.quit();

  }

}
