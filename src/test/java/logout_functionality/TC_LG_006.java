package logout_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LG_006 {

	public static void main(String[] args) {
		
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

		            // Click on 'My Account' Dropmenu
		       WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
		            myAccountDropMenu.click();

		            // Click on 'Register' option
		            WebElement registerOption = driver.findElement(By.linkText("Register"));
		            registerOption.click();

		            // Verify Logout option is not displayed under 'Right Column'
		            boolean isLogoutOptionPresent = driver.findElements(By.linkText("Logout")).size() > 0;

		            if (!isLogoutOptionPresent) 
		            {
		                System.out.println("Test Passed: Logout option is not displayed in the 'Right Column' before logging in");
		            } 
		            else 
		            {
		                System.out.println("Test Failed: Logout option is displayed in the 'Right Column' before logging in");
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

