package register_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC_RF_013
 {

    public static void main(String[] args) 
    {
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
        WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
        myAccountDropMenu.click();

        // Test Step 2: Click on 'Register' option
        WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
        registerOption.click();

        // Test Step 3: Verify Placeholder
        String[][] fields = {
            {"input-firstname", "First Name"},
            {"input-lastname", "Last Name"},
            {"input-email", "E-Mail"},
            {"input-telephone", "Telephone"},
            {"input-password", "Password"},
            {"input-confirm", "Password Confirm"}
        };

        boolean allPlaceholdersCorrect = true;

        for (String[] field : fields) 
        {
            WebElement element = driver.findElement(By.id(field[0]));
            String placeholder = element.getAttribute("placeholder");

            if (placeholder.equals(field[1])) 
            {
                System.out.println("Test Passed: Placeholder for '" + field[1] + "' is correct.");
            } 
            else 
            {
                System.out.println("Test Failed: Placeholder for '" + field[1] + "' is incorrect. Found: '" + placeholder + "'");
                allPlaceholdersCorrect = false;
            }
        }

        if (allPlaceholdersCorrect) 
        {
            System.out.println("All placeholders are correct.");
        } 
        else 
        {
            System.out.println("Some placeholders are incorrect.");
        }

        // Close the browser
        driver.quit();
    }
}

