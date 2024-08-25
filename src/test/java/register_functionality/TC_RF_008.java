package register_functionality;

  
	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	 public class TC_RF_008  {

	    public static void main(String[] args) {
	        

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();
	       // WebDriver driver = new EdgeDriver();
	         // WebDriver driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

	        // Open the Application
	        driver.get("http://tutorialsninja.com/demo");

	        // Maximize the browser window
	        driver.manage().window().maximize();

	         // Test Step 1: Click on 'My Account' Drop menu
	        WebElement myAccount = driver.findElement(By.xpath("//span[@class='caret']"));
	        myAccount.click();

	        // Test Step 2: Click on 'Register' option
	        WebElement register = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
	        register.click();

	        // Test Step 3: Enter new Account Details into all the Fields
	        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Henry");

	        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Agulanna");
           
	        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("automationninja812@yahoo.com");

	        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("01234567890");
	        
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
            
            driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("abcde");
            
            driver.findElement(By.xpath("//input[@name='agree']")).click();

	        driver.findElement(By.xpath("//input[@value='Continue']")).click();

	        // Expected Result: Verify the warning message
	        WebElement warningMessage = driver.findElement(By.xpath("//div[@class='text-danger']"));
	        
	        if (warningMessage.getText().contains("Password confirmation does not match password!")) 
	        {
	            System.out.println("Test Passed: The warning message is displayed correctly.");
	        } 
	        else 
	        {
	            System.out.println("Test Failed: The expected warning message is not displayed.");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}

