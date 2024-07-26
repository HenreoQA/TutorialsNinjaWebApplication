package logout_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LG_004 {

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
         
         // Click on 'My Account' Dropmenu
         driver.findElement(By.xpath("//span[@class='caret']")).click();
         
         //Select 'Logout' option
         driver.findElement(By.linkText("Logout")).click();
         
         // Click on the browser back button
         driver.navigate().back();
         
      // Check if the user is still logged out by looking for the login option
         myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();

         WebElement logoutOption = driver.findElement(By.linkText("Logout"));
         if (logoutOption.isDisplayed()) 
         {
             System.out.println("Test Failed: User is not logged out");
         } 
         else 
         {
             System.out.println("Test Passed: User is logged out");
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
