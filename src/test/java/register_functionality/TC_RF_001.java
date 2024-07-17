package register_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_RF_001  {

	public static void main(String[] args) 
	{
		
        WebDriver driver=new ChromeDriver(); //Launch chrome browser
       
       // WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
		
		driver.get("http://tutorialsninja.com/demo/"); //Open the application
		
		driver.manage().window().maximize(); //Maximise the page
		
		
		try {
            // Click on 'My Account' Drop menu
            WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
            myAccountDropMenu.click();

            // Click on 'Register' option
            WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
            registerOption.click();

            // Enter new Account Details into the Mandatory Fields
            driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Henry");
            driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Agulanna");
            driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("automationninja82@gmail.com");
            driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("01234567890");
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Password123");
            driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Password123");
            

            // Select Privacy Policy
            WebElement privacyPolicyCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
            privacyPolicyCheckbox.click();

            // Click on 'Continue' button
            WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
            continueButton.click();

            // Wait for the 'Account Success' page and click 'Continue' button
            WebElement successContinueButton = driver.findElement(By.xpath("//a[normalize-space()='Continue']"));
            successContinueButton.click();

            // Verify user is taken to 'Account' page
            WebElement accountPageHeading = driver.findElement(By.xpath("//h2[normalize-space()='My Account']"));
            if (accountPageHeading.isDisplayed()) 
            {
                System.out.println("Test Passed: Account page is displayed.");
            } 
            else 
            {
                System.out.println("Test Failed: Account page is not displayed.");
            }

            // Expected result verification
            String expectedTitle = "My Account";
            String actualTitle = driver.getTitle();
            if (expectedTitle.equals(actualTitle)) 
            {
                System.out.println("Test Passed: User is on the Account page.");
            } 
            else 
            {
                System.out.println("Test Failed: User is not on the Account page.");
            }
        } 
		catch (Exception e) 
		{
            e.printStackTrace(); //To know the type of exception
			
        } 
		finally
		{
			 // Close the browser - will execute if there is exception or not
	           driver.quit();
	        
		}
           
    }
		

		
}


