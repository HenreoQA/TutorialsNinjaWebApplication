package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_012 {

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

          // Enter valid email address into the 'E-Mail Address' field
          driver.findElement(By.id("input-email")).sendKeys("xyz2468@yahoo.com");

          // Enter valid password into the 'Password' field
           driver.findElement(By.id("input-password")).sendKeys("xyz2468");

          // Click on 'Login' button
          driver.findElement(By.xpath("//input[@value='Login']")).click();
           
          // Perform 5 unsuccessful login attempts
          for (int i = 1; i <= 5; i++) //i=unsuccessful attempt
          {
                 
              // Click on 'Login' button
              driver.findElement(By.xpath("//input[@value='Login']")).click();
              
             // Check for the presence of a specific warning message on the 5th attempt
              if (i == 5) 
              {
                  WebElement warningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
                  String expectedMessage = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
                  String actualMessage = warningMessage.getText();
                  if (actualMessage.contains(expectedMessage)) 
                  {
                      System.out.println("Test Passed: Warning message displayed as expected on the 5th unsuccessful login attempt.");
                  } 
                  else 
                  {
                      System.out.println("Test Failed: Warning message not displayed as expected on the 5th unsuccessful login attempt.");
                  }
              }
          }
      } 
        catch (Exception e) 
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
