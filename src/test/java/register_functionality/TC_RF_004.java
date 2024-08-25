package register_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_RF_004 {
    public static void main(String[] args) {
   
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        //WebDriver driver = new EdgeDriver();
       //WebDriver driver = new FirefoxDriver();

        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10)); //explicit wait
        

        try {
            // Open the application
            driver.get("http://tutorialsninja.com/demo/");
            driver.manage().window().maximize(); //Maximise the page

            // Click on 'My Account' Drop menu
            WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='caret']")));
            myAccount.click();

            // Click on 'Register' option
            WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']")));
            register.click();

            // Click on 'Continue' button without entering any details
            WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
            continueButton.click();

            // Verify warning messages for the respective fields
            WebElement firstNameWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")));
            WebElement lastNameWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")));
            WebElement emailWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-email']/following-sibling::div")));
            WebElement telephoneWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-telephone']/following-sibling::div")));
            WebElement passwordWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='input-password']/following-sibling::div")));
            WebElement privacyPolicyWarning = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));

            // Assert the warning messages
            assert firstNameWarning.getText().equals("First Name must be between 1 and 32 characters!") : "First Name validation message mismatch";
            assert lastNameWarning.getText().equals("Last Name must be between 1 and 32 characters!") : "Last Name validation message mismatch";
            assert emailWarning.getText().equals("E-Mail Address does not appear to be valid!") : "E-Mail validation message mismatch";
            assert telephoneWarning.getText().equals("Telephone must be between 3 and 32 characters!") : "Telephone validation message mismatch";
            assert passwordWarning.getText().equals("Password must be between 4 and 20 characters!") : "Password validation message mismatch";
            assert privacyPolicyWarning.getText().contains("Warning: You must agree to the Privacy Policy!") : "Privacy Policy validation message mismatch";

            System.out.println("All validation messages are displayed correctly.");

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

