package login_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_LF_009 
 {
	
	 public static void main(String[] args) 
	    {
		    // Initialize WebDriver
	         WebDriver driver = new ChromeDriver();
            // WebDriver driver = new EdgeDriver();
            // WebDriver driver = new FirefoxDriver();
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

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
      
      //Click on browser back button
      driver.navigate().back();
      String actualpagetitle = driver.getTitle();
      if(actualpagetitle.equals("My Account"))
      {
    	 System.out.println("Test passed:user is not logged out on clicking browser back button"); 
      }
      else
      {
    	  System.out.println("Test failed:user is logged out on clicking browser back button"); 
      }
  }
  catch(Exception e)
  {
	 e.printStackTrace(); 
  }
  
       // Close the browser
        driver.quit();


}
  }
