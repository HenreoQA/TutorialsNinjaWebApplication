package search_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_SF_006 {

	public static void main(String[] args) {
		

   	       WebDriver driver=new ChromeDriver(); //Launch chrome browser
        
        // WebDriver driver = new EdgeDriver();
         // WebDriver driver = new FirefoxDriver();
 		
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
 		
 		 try {
             // Open the Application URL
             driver.get("http://tutorialsninja.com/demo");
             driver.manage().window().maximize(); // Maximize the browser window

             // Verify placeholder text for 'Search' text box field on the main page
             WebElement searchBox = driver.findElement(By.name("search"));
             String searchBoxPlaceholder = searchBox.getAttribute("placeholder");

             if (searchBoxPlaceholder != null && !searchBoxPlaceholder.isEmpty()) {
                 System.out.println("Test Passed: 'Search' text box placeholder is displayed as: " + searchBoxPlaceholder);
             } else {
                 System.out.println("Test Failed: 'Search' text box placeholder is not displayed");
             }

             // Click on the button having search icon without entering any text
             WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
             searchButton.click();

             // Verify placeholder text for 'Search Criteria' text box field on the search results page
             WebElement searchCriteriaBox = driver.findElement(By.id("input-search"));
             String searchCriteriaPlaceholder = searchCriteriaBox.getAttribute("placeholder");

             if (searchCriteriaPlaceholder != null && !searchCriteriaPlaceholder.isEmpty()) {
                 System.out.println("Test Passed: 'Search Criteria' text box placeholder is displayed as: " + searchCriteriaPlaceholder);
             } else {
                 System.out.println("Test Failed: 'Search Criteria' text box placeholder is not displayed");
             }

         } catch (Exception e) {
             e.printStackTrace();
         } finally {
             // Close the browser
             driver.quit();
         }


	}

}
