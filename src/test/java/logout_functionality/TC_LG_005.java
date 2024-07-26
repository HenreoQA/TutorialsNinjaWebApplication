package logout_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LG_005 {

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

         // Click on 'My Account' Dropmenu
         driver.findElement(By.xpath("//span[@class='caret']")).click();

         // Check if the 'Logout' option is not displayed
         boolean isLogoutDisplayed = isElementPresent(driver, By.linkText("Logout"));

         if (!isLogoutDisplayed) 
         {
             System.out.println("Test Passed: Logout option is not displayed under 'My Account' dropmenu before logging in");
         } 
         else 
         {
             System.out.println("Test Failed: Logout option is displayed under 'My Account' dropmenu before logging in");
         }

     } catch (Exception e) 
     {
         e.printStackTrace();
     }
     
        //Close browser
          driver.quit();
          
	}

          
       // Method to check if an element is present
          public static boolean isElementPresent(WebDriver driver, By locator) 
          {
              try 
              {
                  driver.findElement(locator);
                  return true;
              } 
              catch (Exception e) 
              {
                  return false;
              }
         }

}
