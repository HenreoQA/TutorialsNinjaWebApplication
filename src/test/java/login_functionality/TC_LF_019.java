package login_functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class TC_LF_019 {

    public static void main(String[] args) {
   

        // Initialize the ChromeDriver
           WebDriver driver = new ChromeDriver();
    	 //WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();
           
        // Set the implicit wait time
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         try {
            // Step 1: Open the application
            driver.get("http://tutorialsninja.com/demo");
            
            // Maximize the browser window
            driver.manage().window().maximize();

            // Step 2: Click on 'My Account' drop menu
            WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
            myAccountDropMenu.click();

            // Step 3: Click on 'Login' option
            WebElement loginOption = driver.findElement(By.xpath("//a[text()='Login']"));
            loginOption.click();

            // Step 4: Click on 'Continue' button under 'New Customer' section
            WebElement continueButton = driver.findElement(By.xpath("//a[text()='Continue']"));
            continueButton.click();

            // Expected result 1: User should be navigated to 'Register Account' page
            if (driver.getTitle().contains("Register Account")) 
            {
                System.out.println("User is navigated to Register Account page successfully");
            } 
            else 
            {
                System.out.println("User failed to navigate to Register Account page");
            }

            // Navigate back to Login page
            driver.navigate().back();

            // Verify navigating to different pages
            // Example: Click on 'About Us' link in the footer
            WebElement AboutUsLink = driver.findElement(By.xpath("//a[text()='About Us']"));
            AboutUsLink.click();

            // Expected result 2: User should be navigated to the appropriate pages
            if (driver.getTitle().contains("About Us")) 
            {
                System.out.println("Navigated to About Us page successfully");
            } 
            else 
            {
                System.out.println("Failed to navigate to About Us page");
            }

            // Navigate back to Login page
            driver.navigate().back();

            // Example: Click on 'Right Column' option (Shopping Cart)
            WebElement forgottenPasswordLink = driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Forgotten Password']"));
            forgottenPasswordLink.click();

            if (driver.getTitle().contains("Forgot Your Password?")) 
            {
                System.out.println("Navigated to Forgot Your Password page successfully");
            } 
            else 
            {
                System.out.println("Failed to navigate to Forgot Your Password page.");
            }

            // Navigate back to Login page
            driver.navigate().back();

            // Example: Click on 'Header' option (Shopping cart)
            WebElement shoppingCartLink = driver.findElement(By.xpath("//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']"));
            shoppingCartLink.click();

            if (driver.getTitle().contains("Shopping Cart")) 
            {
                System.out.println("Navigated to Shopping Cart page successfully...");
            } 
            else 
            {
                System.out.println("Failed to navigate to Shopping Cart page...");
            }

            // Navigate back to Login page
            driver.navigate().back();

            // Example: Click on 'Menu' option (Tablets)
            WebElement tabletsMenu = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]"));
            tabletsMenu.click();

            if (driver.getTitle().contains("Tablets")) 
            {
                System.out.println("Navigated to Tablets page successfully.");
            } 
            else 
            {
                System.out.println("Failed to navigate to Tablets page.");
            }

        }
        catch(Exception e)
        {
          e.printStackTrace();	
        }
        
         //Close browser
           driver .quit();
        	
           
    }
}

