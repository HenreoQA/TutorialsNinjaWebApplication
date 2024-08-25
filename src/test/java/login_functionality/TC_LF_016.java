package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_016 {

	public static void main(String[] args) {
		
		// Initialize WebDriver
        WebDriver driver = new ChromeDriver();
     // WebDriver driver = new EdgeDriver();
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
         driver.findElement(By.id("input-password")).sendKeys("12345");

          // Click on 'Login' button
          driver.findElement(By.xpath("//input[@value='Login']")).click();
          
       // Step 6: Click on 'Change your password' link
          WebElement changepasswordLink = driver.findElement(By.linkText("Change your password"));
          changepasswordLink.click();

          // Step 7: Enter new password
          WebElement newPasswordField = driver.findElement(By.id("input-password"));
          newPasswordField.sendKeys("Password123");
          WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
          confirmPasswordField.sendKeys("Password123");

          // Step 8: Click on 'Continue' button
          WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
          continueButton.click();

          // Step 9: Click on 'My Account' drop menu and select 'Logout' option
          driver.findElement(By.xpath("//span[@class='caret']")).click();
          driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")).click();
       

          // Step 10: Repeat steps 1 to 5
          driver.findElement(By.xpath("//span[@class='caret']")).click();
          driver.findElement(By.xpath("//a[text()='Login']")).click();
          driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");
          driver.findElement(By.id("input-password")).sendKeys("12345");
          driver.findElement(By.xpath("//input[@value='Login']")).click();

          // Verify that user is not logged in with old password
          String loginPageUrl = driver.getCurrentUrl();
          if (loginPageUrl.contains("login")) 
          {
              System.out.println("Test Passed: User is not logged in with old password.");
          } 
          else 
          {
              System.out.println("Test Failed: User is logged in with old password.");
          }

          // Step 11: Enter new credentials and click on 'Login' button
          WebElement passwordField = driver.findElement(By.id("input-password"));
          passwordField.clear();
          passwordField.sendKeys("newPassword123");
          driver.findElement(By.xpath("//input[@value='Login']")).click();

          // Verify that user is logged in with new password
          String accountPageUrl = driver.getCurrentUrl();
          if (accountPageUrl.contains("account")) 
          {
              System.out.println("Test Passed: User is logged in with new password.");
          } 
          else 
          {
              System.out.println("Test Failed: User is not logged in with new password.");
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
