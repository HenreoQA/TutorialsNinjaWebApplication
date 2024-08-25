package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LF_017 {

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
         driver.findElement(By.id("input-password")).sendKeys("Password123");

          // Click on 'Login' button
          driver.findElement(By.xpath("//input[@value='Login']")).click();
          
          //Close the Browser
             driver.quit();
             
             // Reinitialise the WebDriver to open a new browser session
                 driver = new ChromeDriver();
             // driver = new EdgeDriver();
             // driver = new FirefoxDriver();
             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
             driver.get("http://tutorialsninja.com/demo");
             driver.manage().window().maximize();
          
              // Check if the user is still logged in
             WebElement MyAccountPage = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
             boolean isLoggedIn = MyAccountPage.isDisplayed();

             // Verify that the user session is maintained
             if (isLoggedIn) 
             {
               System.out.println("Test Passed: User session is maintained after closing and reopening the browser.");
             } 
             else 
             {
                 System.out.println("Test Failed: User session is not maintained.");
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

