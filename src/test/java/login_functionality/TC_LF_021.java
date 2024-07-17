package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TC_LF_021
{
    public static void main(String[] args) 
  {
        
       // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
     // WebDriver driver = new EdgeDriver();
    //  WebDriver driver = new FirefoxDriver();
        
          //Set implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

        try {
                // Open the application
            driver.get("http://tutorialsninja.com/demo");
            
            //Maximise the browser window
            driver.manage().window().maximize();

            // Click on 'My Account' Dropmenu
            WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
            myAccountDropMenu.click();

            // Click on 'Login' option
            WebElement loginOption = driver.findElement(By.xpath("//a[text()='Login']"));
            loginOption.click();

            // Expected result: Proper Breadcrumb, Page Heading, Page URL and Page Title should be displayed

            // Verify Breadcrumb
            WebElement breadcrumb = driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']"));
            if (breadcrumb.isDisplayed()) 
            {
                System.out.println("Breadcrumb is displayed correctly");
            } 
            else 
            {
                System.out.println("Breadcrumb is not displayed correctly");
            }

            // Verify Page Heading
            WebElement pageHeading = driver.findElement(By.xpath("//h2[text()='Returning Customer']"));
            if (pageHeading.isDisplayed()) 
            {
                System.out.println("Page heading is displayed correctly");
            } 
            else 
            {
                System.out.println("Page heading is not displayed correctly");
            }

            // Verify Page URL
            String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/login";
            String actualUrl = driver.getCurrentUrl();
            if (expectedUrl.equals(actualUrl)) 
            {
                System.out.println("Page URL is correct: " + actualUrl);
            } 
            else 
            {
                System.out.println("Page URL is incorrect: " + actualUrl);
            }

            // Verify Page Title
            String expectedTitle = "Account Login";
            String actualTitle = driver.getTitle();
            if (expectedTitle.equals(actualTitle)) 
            {
                System.out.println("Page title is correct: " + actualTitle);
            } 
            else 
            {
                System.out.println("Page title is incorrect: " + actualTitle);
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
