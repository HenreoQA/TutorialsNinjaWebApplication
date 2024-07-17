package register_functionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_RF_023
{

    public static void main(String[] args) 
    {
        
        // Initialize WebDriver
           WebDriver driver = new ChromeDriver();
          // WebDriver driver = new EdgeDriver();
          // WebDriver driver = new FirefoxDriver();
        
            try {
                // Open the Application
                driver.get("http://tutorialsninja.com/demo");

                // Maximize the browser window
                driver.manage().window().maximize();

                // Initialize WebDriverWait
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

                // Test Step 1: Click on 'My Account' Drop menu
                WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='caret']")));
                myAccount.click();

                // Test Step 2: Click on 'Register' option
                WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Register']")));
                register.click();
                
                // Test Step 3: Click on 'privacy policy' link
                WebElement privacyPolicyLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[normalize-space()='Privacy Policy']")));
                privacyPolicyLink.click();
                                
                // Refresh the Page
                driver.navigate().refresh();

                // Test Step 3: Click on 'login page' link
                WebElement loginPageLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='login page']")));
                loginPageLink.click();
                
                // Verify navigation to Login Page
                verifyNavigation(driver, "Account Login");

                // Navigate back to Register Page
                driver.navigate().back();
                
                // Test Step 3: Header options - Click on other options and verify navigations
                
                List<WebElement> otheroptions= driver.findElements(By.xpath("//ul[@class='list-inline']/li")); 
               
                for(WebElement options:otheroptions)
                {
                	options.click();
                    break;
                }
                
                // Navigate back to Register Page
                driver.navigate().back();
                
                // Click on currency option
                driver.findElement(By.xpath("//i[@class='fa fa-caret-down']")).click();
                
                // Refresh the Page
                driver.navigate().refresh();
                
                // Click on Logo
                driver.findElement(By.xpath("//a[normalize-space()='Qafox.com']")).click();
                
                // Verify navigation to logo option
                verifyNavigation(driver, "Your Store");
                
                // Navigate back to Register Page
                driver.navigate().back();
                
                // Click on search button
                driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
                
                // Verify navigation to search option
                verifyNavigation(driver, "Search");
                
                // Navigate back to Register Page
                driver.navigate().back();
                
                //Click on shopping cart option
                driver.findElement(By.xpath("//span[@id='cart-total']")).click();
                
                // Refresh the Page
                driver.navigate().refresh();
                
                // Test Step 3: Click on menu options
                
                List<WebElement> menuoptions= driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li")); 
                
                for(WebElement menu:menuoptions)
                {
                	menu.click();
                    break;
                }
                
                // Refresh the Page
                driver.navigate().refresh();
                
                // Test Step 3: Click on the footer options
                
         List<WebElement> footeroptions= driver.findElements(By.tagName("footer a")); 
                
                for(WebElement footer:footeroptions)
                {
                	footer.click();
                    break;
                }
                
                // Navigate back to Register Page
                driver.navigate().back();
                
               // Test Step 3: Click on 'Right Column' options
                
                List<WebElement> Rightcolumnoptions= driver.findElements(By.className("list-group-item"));              
                  
                  for(WebElement options:Rightcolumnoptions)
                  {
                  	options.click();
                  	break;
                  	
                  }
               
              } 
            catch (Exception e) 
    		{
                e.printStackTrace(); 
    			
            } 
            
               // Close the browser
                driver.quit();
            
        }

        public static void verifyNavigation(WebDriver driver, String expectedTitle) 
        {
            // Wait for the page to load and get the page title
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains(expectedTitle));

            // Get the current page title
            String actualTitle = driver.getTitle();

            // Verify the title contains the expected text
            if (actualTitle.contains(expectedTitle)) 
            {
                System.out.println("Navigation to " + expectedTitle + " Page is successful.");
            } 
            else 
            {
                System.out.println("Navigation to " + expectedTitle + " Page failed. Actual title: " + actualTitle);
            }
        }
    
            
   }
