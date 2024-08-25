package register_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_RF_018 
{

    public static void main(String[] args) 
    {    
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        //WebDriver driver = new EdgeDriver();
       // WebDriver driver = new FirefoxDriver();

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

        // Test Step 3: Check all the fields
        verifyFieldRequirements(driver, "input-firstname", "First Name", 30, 100, 32);
        verifyFieldRequirements(driver, "input-lastname", "Last Name", 30, 100, 32);
        verifyFieldRequirements(driver, "input-email", "E-Mail", 30, 100, 50);
        verifyFieldRequirements(driver, "input-telephone", "Telephone", 30, 100, 32);
        verifyFieldRequirements(driver, "input-password", "Password", 30, 100, 20);
        verifyFieldRequirements(driver, "input-confirm", "Password Confirm", 30, 100, 20);
        
        // Checking 'Newsletter' and 'Privacy Policy' doesn't require dimensions and character checks, but we can confirm presence
       
        WebElement newsletter = driver.findElement(By.name("newsletter"));
        if (newsletter.isDisplayed()) 
        {
            System.out.println("Newsletter field is present");
        } 
        else 
        {
            System.out.println("Newsletter field is not present");
        }
        
        
        WebElement PrivacyPolicy = driver.findElement(By.name("agree"));
        if (PrivacyPolicy.isDisplayed()) 
        {
            System.out.println("Privacy Policy field is present");
        } 
        else 
        {
            System.out.println("Privacy Policy field is not present");
        }

      
        // Verify the presence of 'Continue' button
       
        WebElement button = driver.findElement(By.xpath("//input[@value='Continue']"));
        if (button.isDisplayed()) 
        {
            System.out.println("Continue button is present.");
        } 
        else 
        {
            System.out.println("Continue button is not present.");
        }
        
            
        // Close the browser
        driver.quit();
    }

    private static void verifyFieldRequirements(WebDriver driver, String fieldId, String fieldName, int expectedHeight, int expectedWidth, int expectedMaxChars) 
    {
        WebElement field = driver.findElement(By.id(fieldId));

        // Check dimensions
        Dimension dimension = field.getSize();
        if (dimension.getHeight() == expectedHeight && dimension.getWidth() == expectedWidth) 
        {
            System.out.println(fieldName + " field dimensions are correct.");
        } 
        else 
        {
            System.out.println(fieldName + " field dimensions are incorrect.");
        }

        // Check max length
        String maxLength = field.getAttribute("maxlength");
        if (maxLength != null && Integer.parseInt(maxLength) == expectedMaxChars) 
        {
            System.out.println(fieldName + " field max length is correct.");
        } 
        else 
        {
            System.out.println(fieldName + " field max length is incorrect or not specified.");
        }
    }

  }

