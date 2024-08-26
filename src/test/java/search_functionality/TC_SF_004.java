package search_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_SF_004 {

	 public static void main(String[] args) {
	        
    	 WebDriver driver=new ChromeDriver(); //Launch chrome browser
         
         // WebDriver driver = new EdgeDriver();
          // WebDriver driver = new FirefoxDriver();
  		
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
  		
        try {
            // Open the Application URL
            driver.get("http://tutorialsninja.com/demo");
            driver.manage().window().maximize(); // Maximize the browser window
            
            //Login to the Application
            driver.findElement(By.xpath("//span[@class='caret']")).click();
            driver.findElement(By.xpath("//a[text()='Login']")).click();
            driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("automationninja@gmail.com");
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Password123");
            driver.findElement(By.xpath("//input[@value='Login']")).click();

            // Enter the existing product name into the 'Search' text box
            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.sendKeys("imac");

            // Click on the button having search icon
            WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
            searchButton.click();

            // Verify that searched product is displayed in the search results
            WebElement searchResult = driver.findElement(By.linkText("iMac"));

            if (searchResult.isDisplayed()) {
                System.out.println("Test Passed: The product 'iMac' is displayed in the search results");
            } else {
                System.out.println("Test Failed: The product 'iMac' is not displayed in the search results");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

