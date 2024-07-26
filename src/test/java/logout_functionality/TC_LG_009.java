package logout_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_LG_009 {

	public static void main(String[] args) {
		
		// Initialize the WebDriver
          WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
        //WebDriver driver = new FirefoxDriver();
    
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

        // Verify the 'Account Logout' page
        // Page Heading
        WebElement pageHeading = driver.findElement(By.xpath("//h1[text()='Account Logout']"));
        if (pageHeading.isDisplayed() && pageHeading.getText().equals("Account Logout")) 
        {
            System.out.println("Page Heading is displayed");
        } 
        else 
        {
            System.out.println("Page Heading is not displayed");
        }

        // Page Title
        String pageTitle = driver.getTitle();
        if (pageTitle.equals("Account Logout")) 
        {
            System.out.println("Page Title is displayed");
        } 
        else 
        {
            System.out.println("Page Title is not displayed.");
        }

        // Page URL
        String pageURL = driver.getCurrentUrl();
        if (pageURL.contains("route=account/logout")) 
        {
            System.out.println("Page URL is displayed");
        } 
        else 
        {
            System.out.println("Page URL is not displayed");
        }

        // Breadcrumb
        WebElement breadcrumb = driver.findElement(By.xpath("//ul[@class='breadcrumb']"));
        if (breadcrumb.isDisplayed()) 
        {
            System.out.println("Breadcrumb is displayed");
        } 
        else 
        {
            System.out.println("Breadcrumb is displayed");
        }

    } catch (Exception e) 
    {
        e.printStackTrace();
    } 
    
        //Close browser
          driver.quit();

	}

}
