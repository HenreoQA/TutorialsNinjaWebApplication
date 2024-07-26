package logout_functionality;

    import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

    import java.time.Duration;


	public class TC_LG_007  {
	  
		public static void main(String[] args) 
		{
           // Initialize the WebDrivers for Firefox and Chrome
	        WebDriver firefoxDriver = new FirefoxDriver();
	        WebDriver chromeDriver = new ChromeDriver(); //Assuming this simulates the mobile device

	        try {
	            // Maximize the browser windows
	            firefoxDriver.manage().window().maximize();
	            chromeDriver.manage().window().maximize();

	            // Set the implicit wait time
	            firefoxDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	            // Open the application in Firefox
	            firefoxDriver.get("http://tutorialsninja.com/demo");

	            // Open the application in Chrome (mobile)
	            chromeDriver.get("http://tutorialsninja.com/demo");

	            // Log in on Firefox
	            WebElement myAccountDropMenuFirefox = firefoxDriver.findElement(By.xpath("//span[@class='caret']"));
	            myAccountDropMenuFirefox.click();
	            WebElement loginOptionFirefox = firefoxDriver.findElement(By.linkText("Login"));
	            loginOptionFirefox.click();
	            WebElement emailFieldFirefox = firefoxDriver.findElement(By.id("input-email"));
	            WebElement passwordFieldFirefox = firefoxDriver.findElement(By.id("input-password"));
	            emailFieldFirefox.sendKeys("automationninja@gmail.com");
	            passwordFieldFirefox.sendKeys("Password123");
	            WebElement loginButtonFirefox = firefoxDriver.findElement(By.xpath("//input[@value='Login']"));
	            loginButtonFirefox.click();

	            // Log in on Chrome (mobile)
	            WebElement myAccountDropMenuChrome = chromeDriver.findElement(By.xpath("//span[@class='caret']"));
	            myAccountDropMenuChrome.click();
	            WebElement loginOptionChrome = chromeDriver.findElement(By.linkText("Login"));
	            loginOptionChrome.click();
	            WebElement emailFieldChrome = chromeDriver.findElement(By.id("input-email"));
	            WebElement passwordFieldChrome = chromeDriver.findElement(By.id("input-password"));
	            emailFieldChrome.sendKeys("automationninja@gmail.com");
	            passwordFieldChrome.sendKeys("Password123");
	            WebElement loginButtonChrome = chromeDriver.findElement(By.xpath("//input[@value='Login']"));
	            loginButtonChrome.click();

	            // Logout on Firefox
	            myAccountDropMenuFirefox = firefoxDriver.findElement(By.xpath("//span[@class='caret']"));
	            myAccountDropMenuFirefox.click();
	            WebElement logoutOptionFirefox = firefoxDriver.findElement(By.linkText("Logout"));
	            logoutOptionFirefox.click();

	            // Verify user is logged out on Chrome (mobile)
	            WebElement addressBookOptionChrome = chromeDriver.findElement(By.linkText("Address Book"));
	            addressBookOptionChrome.click();

	            // Check if user is redirected to login page
	            boolean isLoginPageDisplayed = chromeDriver.findElements(By.id("input-email")).size() > 0;

	            if (isLoginPageDisplayed) 
	            {
	                System.out.println("Test Passed: User is logged out in Mobile device too");
	            } 
	            else 
	            {
	                System.out.println("Test Failed: User is not logged out in Mobile device");
	            }

	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        } 
	        
	                //Close drivers
	                firefoxDriver.quit();
	                chromeDriver.quit();
	         
	    }
	}


