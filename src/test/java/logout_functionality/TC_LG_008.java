package logout_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LG_008 {
	
	public static void main(String[] args) {
		// Initialize the WebDriver
         WebDriver driver = new ChromeDriver();
      // WebDriver driver = new EdgeDriver();
     //  WebDriver driver = new FirefoxDriver();
     
       //Set implicit wait time
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 
     
     try {
         // Maximize the browser window
         driver.manage().window().maximize();

         // Open the application
         driver.get("http://tutorialsninja.com/demo");

         // Log in with a valid account
         WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();
         WebElement loginOption = driver.findElement(By.linkText("Login"));
         loginOption.click();
         WebElement emailField = driver.findElement(By.id("input-email"));
         WebElement passwordField = driver.findElement(By.id("input-password"));
         emailField.sendKeys("automationninja@gmail.com");
         passwordField.sendKeys("Password123");
         WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
         loginButton.click();

         // Perform logout
         myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();
         WebElement logoutOption = driver.findElement(By.linkText("Logout"));
         logoutOption.click();

         // Verify if logout was successful and login option is displayed
         myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();
         boolean isLoginDisplayed = driver.findElement(By.linkText("Login")).isDisplayed();

         if (isLoginDisplayed) 
         {
             System.out.println("Logout successful, Login option is displayed");
         } 
         else 
         {
             System.out.println("Logout failed, Login option is not displayed");
         }

         // Log in immediately again with the same account
         myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();
         loginOption = driver.findElement(By.linkText("Login"));
         loginOption.click();
         emailField = driver.findElement(By.id("input-email"));
         passwordField = driver.findElement(By.id("input-password"));
         emailField.sendKeys("automationninja@gmail.com");
         passwordField.sendKeys("Password123");
         loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
         loginButton.click();

         // Verify if login was successful with the same account
         myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();
         boolean isLogoutDisplayed = driver.findElement(By.linkText("Logout")).isDisplayed();

         if (isLogoutDisplayed) 
         {
             System.out.println("Login with the same account is successful");
         } 
         else 
         {
             System.out.println("Login with the same account failed");
         }

         // Perform logout again
         logoutOption= driver.findElement(By.linkText("Logout"));
         logoutOption.click();

         // Log in immediately again with a different account
         myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();
         loginOption = driver.findElement(By.linkText("Login"));
         loginOption.click();
         emailField = driver.findElement(By.id("input-email"));
         passwordField = driver.findElement(By.id("input-password"));
         emailField.sendKeys("ije@gmail.com");
         passwordField.sendKeys("123456");
         loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
         loginButton.click();

         // Verify if login was successful with the different account
         myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
         myAccountDropMenu.click();
         isLogoutDisplayed = driver.findElement(By.linkText("Logout")).isDisplayed();

         if (isLogoutDisplayed) 
         {
             System.out.println("Login with a different account is successful");
         } 
         else 
         {
             System.out.println("Login with a different account failed");
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
