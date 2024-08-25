package logout_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LG_002 {

	public static void main(String[] args) 
	{
		 // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
     // WebDriver driver = new EdgeDriver();
     // WebDriver driver = new FirefoxDriver();
     
        //Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
        
        try {
        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the application
        driver.get("http://tutorialsninja.com/demo");

        //Click on 'My Account' Dropmenu and select 'Login' option
       driver.findElement(By.xpath("//span[@class='caret']")).click();
        
        driver.findElement(By.linkText("Login")).click();

        // Enter valid email address into the 'E-Mail Address' field
        WebElement emailField = driver.findElement(By.id("input-email"));
        emailField.sendKeys("automationninja@gmail.com");

        // Enter valid password into the 'Password' field
        WebElement passwordField = driver.findElement(By.id("input-password"));
        passwordField.sendKeys("Password123");

        // Click on 'Login' button
         driver.findElement(By.xpath("//input[@value='Login']")).click();
         
         //Click on logout option from the right column
         driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
         
      // Expected Result 1: Verify user is taken to 'Account Logout' page and 'Login' option is visible under 'My Account' dropmenu
         WebElement accountLogoutHeader = driver.findElement(By.xpath("//h1[text()='Account Logout']"));
         if (accountLogoutHeader.isDisplayed()) 
         {
             System.out.println("User is taken to 'Account Logout' page");
         } 
         else 
         {
             System.out.println("User is not taken to 'Account Logout' page");
         }

         driver.findElement(By.xpath("//span[@class='caret']")).click(); //click on My Account dropmenu
         WebElement loginOptionAfterLogout = driver.findElement(By.linkText("Login")); //capture login element
         if (loginOptionAfterLogout.isDisplayed()) 
         {
             System.out.println("Login option is visible under 'My Account' dropmenu");
         } 
         else 
         {
             System.out.println("Login option is not visible under 'My Account' dropmenu");
         }

         //Click on 'Continue' button
         driver.findElement(By.linkText("Continue")).click();

         // Expected Result 2: Verify user is taken to the Home page
         String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=common/home";
         String actualUrl = driver.getCurrentUrl();
         if (expectedUrl.equals(actualUrl)) 
         {
             System.out.println("User is taken to the Home page");
         } 
         else 
         {
             System.out.println("User is not taken to the Home page");
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
