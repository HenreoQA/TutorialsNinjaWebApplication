package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_010 {

	public static void main(String[] args) 
	{
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
          driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");

          // Enter valid password into the 'Password' field
         driver.findElement(By.id("input-password")).sendKeys("Password123");

          // Click on 'Login' button
          driver.findElement(By.xpath("//input[@value='Login']")).click();
          
          //Click on 'My Account' Dropmenu
          driver.findElement(By.xpath("//span[@class='caret']")).click();
          
          //Click on Logout option
          WebElement Logoutoption = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']"));
          Logoutoption.click();
          
          // Click on Browser back button
          driver.navigate().back();

          // Verify the user is not logged in again
          String actualpagetitle = driver.getTitle();
          String expectedpagetitle = "Account Logout";
          if(actualpagetitle.equals(expectedpagetitle))
          {
              System.out.println("Test Passed: User is not logged in again after using the browser back button.");
          } 
          else 
          {
              System.out.println("Test Failed: User is logged in again after using the browser back button.");
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
