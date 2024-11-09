package search_functionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_SF_005 {

	public static void main(String[] args) {
		
 WebDriver driver=new ChromeDriver(); //Launch chrome browser
         
         // WebDriver driver = new EdgeDriver();
          // WebDriver driver = new FirefoxDriver();
  		
  		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
  		
        try {
            // Open the Application URL
            driver.get("http://tutorialsninja.com/demo");
            driver.manage().window().maximize(); // Maximize the browser window

            // Enter the search criteria in the 'Search' text box
            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.sendKeys("Mac");

            // Click on the button having search icon
            WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
            searchButton.click();

         // More than one product should be displayed in the search results page
            List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='product-thumb']")); 
            
            if (searchResults.size() > 1) 
            {
                System.out.println("Test Passed: More than one product is displayed in the search results page");
            } else {
                System.out.println("Test Failed: Less than or equal to one product is displayed in the search results page");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }


	}

}
