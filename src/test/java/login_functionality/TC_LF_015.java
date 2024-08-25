package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_015 {

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
          
          // Enter text into the 'Password' field
          WebElement passwordfield = driver.findElement(By.id("input-password"));
          passwordfield.sendKeys("Password123");
          
          // Inspect the page source to verify the password is not visible
          String pageSourceBeforeLogin = driver.getPageSource();
          if (pageSourceBeforeLogin.contains("Password123")) 
          {
              System.out.println("Test Failed: Password text is visible in the page source before login");
          } 
          else 
          {
              System.out.println("Test Passed: Password text is not visible in the page source before login");
          }
          
           // Enter valid email address into the 'E-Mail Address' field
          driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");

           // Click on 'Login' button
          WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
          loginButton.click();

          // Inspect the page source again to verify the password is not visible
          String pageSourceAfterLogin = driver.getPageSource();
          if (pageSourceAfterLogin.contains("Password123")) 
          {
              System.out.println("Test Failed: Password text is visible in the page source after login");
          }
          else 
          {
              System.out.println("Test Passed: Password text is not visible in the page source after login");
          }
      } 
        catch (Exception e) 
        {
          e.printStackTrace();
        } 
        
        //Close browser
          driver.quit();

	}

}
