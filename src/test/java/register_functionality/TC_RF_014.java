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

public class TC_RF_014
 {

      public static void main(String[] args) 
    {   
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

        // Test Step 3: Verify red colour * symbol for each mandatory field
        verifyMandatoryField(driver, wait, "First Name", "//label[normalize-space()='First Name']");
        verifyMandatoryField(driver, wait, "Last Name", "//label[normalize-space()='Last Name']");
        verifyMandatoryField(driver, wait, "E-Mail", "//label[normalize-space()='E-Mail']");
        verifyMandatoryField(driver, wait, "Telephone", "//label[normalize-space()='E-Mail']");
        verifyMandatoryField(driver, wait, "Password", "//label[normalize-space()='Password']");
        verifyMandatoryField(driver, wait, "Password Confirm", "//label[normalize-space()='Password Confirm']");
        verifyMandatoryField(driver, wait, "Privacy Policy", "//input[@name='agree']");

        // Close the browser
        driver.quit();
    }

    private static void verifyMandatoryField(WebDriver driver, WebDriverWait wait, String fieldName, String xpath) 
    {
        try {
            WebElement requiredSymbol = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            String color = requiredSymbol.getCssValue("color");

            // Assuming the color is in rgba format, red color will be rgba(255, 0, 0, 1)
            if (color.equals("rgba(255, 0, 0,1)")) 
            {
                System.out.println("Test Passed: Red color * symbol is displayed for the mandatory field '" + fieldName + "'.");
            } 
            else 
            {
                System.out.println("Test Failed: Red color * symbol is not correctly displayed for the mandatory field '" + fieldName + "'. Actual color: " + color);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Test Failed: Red color * symbol is not displayed for the mandatory field '" + fieldName + "'.");
        }
    }
}
