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

public class TC_RF_025
{

    public static void main(String[] args) {
        

        // Initialize WebDriver
         WebDriver driver = new ChromeDriver();
       //WebDriver driver = new EdgeDriver();
       //WebDriver driver = new FirefoxDriver();


        
            // Open the Application
            driver.get("http://tutorialsninja.com/demo");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Test Step 1: Click on 'My Account' Drop menu
            WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='caret']")));
            myAccount.click();

            // Test Step 2: Click on 'Register' option
            WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']")));
            register.click();

            // Expected Result: Proper Breadcrumb, Page Heading, Page URL and Page Title should be displayed

            // Verify Breadcrumb
            WebElement breadcrumb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Register']")));
            String breadcrumbText = breadcrumb.getText();
            if (breadcrumbText.equals("Register")) 
            {
                System.out.println("Breadcrumb verification passed.");
            } 
            else 
            {
                System.out.println("Breadcrumb verification failed. Actual breadcrumb: " + breadcrumbText);
            }

            // Verify Page Heading
            WebElement pageHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Register Account']")));
            String pageHeadingText = pageHeading.getText();
            if (pageHeadingText.equals("Register Account")) 
            {
                System.out.println("Page Heading verification passed.");
            } 
            else 
            {
                System.out.println("Page Heading verification failed. Actual heading: " + pageHeadingText);
            }
            
            // Verify Page URL
            String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/register";
            String actualURL = driver.getCurrentUrl();
            if (actualURL.equals(expectedURL)) 
            {
                System.out.println("Page URL verification passed.");
            } 
            else 
            {
                System.out.println("Page URL verification failed. Actual URL: " + actualURL);
            }

            // Verify Page Title
            String expectedTitle = "Register Account";
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) 
            {
                System.out.println("Page Title verification passed.");
            } 
            else 
            {
                System.out.println("Page Title verification failed. Actual title: " + actualTitle);
            }

        
            // Close the browser
            driver.quit();
        
    }
}

