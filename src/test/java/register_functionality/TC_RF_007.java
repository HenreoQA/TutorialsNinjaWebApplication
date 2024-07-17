package register_functionality;



	import java.time.Duration;

    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class TC_RF_007 
	{
	    public static void main(String[] args) {
	       

	        // Initialize WebDriver
	          WebDriver driver = new ChromeDriver();
	       // WebDriver driver = new EdgeDriver();
	         // WebDriver driver = new FirefoxDriver();

	        // Initialize WebDriverWait
	        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	        
	       
	        // Open the Application
	        driver.get("http://tutorialsninja.com/demo");
	        driver.manage().window().maximize();

	        
	        // Step 1: Click on 'My Account' Drop menu
	        WebElement myAccountDropdown = driver.findElement(By.xpath("//span[@class='caret']"));
	        myAccountDropdown.click();

	        // Step 2: Click on 'Register' option
	        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
	        registerOption.click();

	        // Verify if navigated to 'Register Account' page
	        verifyRegisterPage(driver);

	        // Navigate back to the homepage
	        driver.navigate().back();

	        // Step 3: Click on 'My Account' Drop menu
	        myAccountDropdown = driver.findElement(By.xpath("//span[@class='caret']"));
	        myAccountDropdown.click();

	        // Step 4: Click on 'Login' option
	        WebElement loginOption = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
	        loginOption.click();

	        // Step 5: Click on 'Continue' button inside 'New Customer' box
	        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Continue']")));
	        continueButton.click();

	        // Verify if navigated to 'Register Account' page
	        verifyRegisterPage(driver);

	        // Navigate back to the homepage
	        driver.navigate().back();

	        // Step 6: Repeat Steps 3 and 4
	        myAccountDropdown = driver.findElement(By.xpath("//span[@class='caret']"));
	        myAccountDropdown.click();
	        loginOption = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
	        loginOption.click();

	        // Step 7: Click on 'Register' option from the Right Column options
	        WebElement rightColumnRegisterOption = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Register']"));
	        rightColumnRegisterOption.click();

	        // Verify if navigated to 'Register Account' page
	        verifyRegisterPage(driver);

	        // Close the browser
	        driver.quit();
	    }

	    // Method to verify if the user is on the 'Register Account' page
	    public static void verifyRegisterPage(WebDriver driver) 
	    {
	    	 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	        WebElement registerPageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Register Account']")));
	        
	        if (registerPageHeader.isDisplayed()) 
	        {
	            System.out.println("User is on the 'Register Account' page.");
	        } 
	        else 
	        {
	            System.out.println("Failed to navigate to the 'Register Account' page.");
	        }
	    }
	    
	    
	}


