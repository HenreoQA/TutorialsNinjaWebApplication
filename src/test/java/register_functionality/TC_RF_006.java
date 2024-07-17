package register_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_RF_006 
{
	 public static void main(String[] args) {
	        
		  // Set up the WebDriver
	         WebDriver driver = new ChromeDriver();
	         //WebDriver driver = new EdgeDriver();
	         // WebDriver driver = new FirefoxDriver();

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

	        try {
	            // Open the application
	            driver.get("http://tutorialsninja.com/demo/");
	            driver.manage().window().maximize();

	            // Step 1: Click on 'My Account' Drop menu
	            WebElement myAccount = driver.findElement(By.xpath("//span[@class='caret']"));
	            myAccount.click();

	            // Step 2: Click on 'Register' option
	            WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
	            register.click();

	            // Step 3: Enter new Account Details into all the Fields
	            driver.findElement(By.id("input-firstname")).sendKeys("Tom");
	            driver.findElement(By.id("input-lastname")).sendKeys("Harry");
	            driver.findElement(By.id("input-email")).sendKeys("tomy2harry@yahoo.com");
	            driver.findElement(By.id("input-telephone")).sendKeys("01234567890");
	            driver.findElement(By.id("input-password")).sendKeys("Test123");
	            driver.findElement(By.id("input-confirm")).sendKeys("Test123");
	            driver.findElement(By.name("agree")).click(); // Select Privacy Policy

	            
	            // Step 4: Click on 'No' radio option for Newsletter
	            WebElement newsletterYes = driver.findElement(By.xpath("//input[@value='0']"));
	            newsletterYes.click();
	            
	            
	            // Step 5: Click on 'Continue' button
	            WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
	            continueButton.click();
	            
	         // Expected result 1: User should be logged in and taken to 'Account Success' page
	            
	            WebElement accountSuccessMessage = driver.findElement(By.xpath("//div[@id='content']/h1"));
	            String msg = accountSuccessMessage.getText();
	            if(msg.equals("Your Account Has Been Created!"))
	            {
	            	System.out.println("User is on account success page");
	            }
	            else
	            {
	            	System.out.println("User is not on account success page");
	            }
	            

	            // Step 6: Click on 'Continue' button that is displayed in the 'Account Success' page
	            WebElement accountSuccessContinue = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
	            accountSuccessContinue.click();
	          
	            // Expected result 2: User should be taken to 'Account' page
	            WebElement accountPage = driver.findElement(By.xpath("//h2[text()='My Account']"));
	            assert accountPage.isDisplayed() : "Account page not displayed.";


	            // Step 7: Click on 'Subscribe/unsubscribe to newsletter' option
	            WebElement newsletterOption = driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter"));
	            newsletterOption.click();
	  
	          // Expected result 3: 'No' option should be displayed as selected by default in the Newsletter page
	            WebElement newsletterYesSelected = driver.findElement(By.xpath("//input[@value='0']"));
	            assert newsletterYesSelected.isSelected() : "'No' option is not selected by default in the Newsletter page.";

	            System.out.println("Test case passed: User registered and 'No' option for Newsletter is selected by default.");
	            
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            // Close the browser
	            driver.quit();
	        }
	    }

}
