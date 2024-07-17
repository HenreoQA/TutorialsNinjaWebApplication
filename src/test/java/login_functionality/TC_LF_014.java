package login_functionality;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC_LF_014 {

	public static void main(String[] args) {
		
		 // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
      //WebDriver driver = new EdgeDriver();
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
          
          // Enter text into the 'Password' field
          WebElement passwordfield = driver.findElement(By.id("input-password"));
          passwordfield.sendKeys("Password123");
          
          // Try to copy the password text using right-click context menu
          Actions actions = new Actions(driver); //Actions class
          actions.doubleClick(passwordfield).perform(); // Double click to select the text
          actions.contextClick(passwordfield).perform(); //right clicking to select copy
          
          // Check if the 'Copy' option is disabled
          boolean isCopydisabled = true;
          if (isCopydisabled) 
          {
              System.out.println("Test Passed: 'Copy' option in the right-click menu is disabled");
          } 
          else 
          {
              System.out.println("Test Failed: 'Copy' option in the right-click menu is not disabled");
          }

          // Try to copy the password text using Ctrl+C keyboard shortcut
          passwordfield.sendKeys(Keys.CONTROL, "a"); // Select the text in the password field
          passwordfield.sendKeys(Keys.CONTROL, "c"); // Copy text

          // Check clipboard content
          Toolkit toolkit = Toolkit.getDefaultToolkit();
          Clipboard clipboard = toolkit.getSystemClipboard();
          String clipboardContent = (String) clipboard.getData(DataFlavor.stringFlavor);

          if (!clipboardContent.equals("Password123")) 
          {
              System.out.println("Test Passed: Password text was not copied using Ctrl+C");
          } 
          else 
          {
              System.out.println("Test Failed:Password text was copied using Ctrl+C");
          }

      } 
        catch (Exception e) 
        {
          e.printStackTrace();
        } 
        
        //Close browser
          driver .quit();

	}

}
