package logout_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LG_003 {

	public static void main(String[] args) {
		// Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
      //WebDriver driver = new EdgeDriver();
     // WebDriver driver = new FirefoxDriver();
     
       //Set implicit wait time
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
     
     try {
         // Maximize the browser window
         driver.manage().window().maximize();

         // Open the application
         driver.get("http://tutorialsninja.com/demo");

         // Click on 'My Account' Dropmenu and select 'Login' option
         WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();
         
         WebElement loginOption = driver.findElement(By.linkText("Login"));
         loginOption.click();

         // Enter valid email address into the 'E-Mail Address' field
         driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");
         
         // Enter valid password into the 'Password' field
         driver.findElement(By.id("input-password")).sendKeys("Password123");
         
         // Click on 'Login' button
         driver.findElement(By.xpath("//input[@value='Login']")).click();

         // Close the browser
         driver.quit();

         // Reinitialize the WebDriver
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
         

         // Open the application again
         driver.get("http://tutorialsninja.com/demo");

         // Check if the user is still logged in by looking for the 'My Account' dropmenu
         myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();

         WebElement accountOption = driver.findElement(By.linkText("My Account"));
         if (accountOption.isDisplayed()) 
         {
             System.out.println("Test Passed: User session is maintained");
         } 
         else 
         {
             System.out.println("Test Failed: User session is not maintained");
         }

     } catch (Exception e) 
     {
         e.printStackTrace();
     } 
     
        //Close browser
          driver.quit();

	}

}
