package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_011 {

	public static void main(String[] args) {
		 // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
     // WebDriver driver = new EdgeDriver();
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

          // Enter valid email address of an inactive account into the 'E-Mail Address' field
          driver.findElement(By.id("input-email")).sendKeys("sosolo@gmail.com");

          // Enter valid password of an inactive account into the 'Password' field
         driver.findElement(By.id("input-password")).sendKeys("Test123@");

          // Click on 'Login' button
          driver.findElement(By.xpath("//input[@value='Login']")).click();
          
          // Verify the user is not able to log in
          WebElement ErrorMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
          if(ErrorMsg.isDisplayed())
          {
        	  System.out.println("Test Passed: User is not able to log in with inactive credentials...");
          }
          else
          {
        	  System.out.println("Test Failed: User is able to log in with inactive credentials...");
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
