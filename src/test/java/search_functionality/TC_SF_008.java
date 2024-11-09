package search_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_SF_008 {

	public static void main(String[] args) {
		
		 WebDriver driver=new ChromeDriver(); //Launch chrome browser
	        
	        // WebDriver driver = new EdgeDriver();
	         // WebDriver driver = new FirefoxDriver();
	 		
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
	 		
	 		try {
	            // Open the Application URL
	            driver.get("http://tutorialsninja.com/demo");
	            driver.manage().window().maximize(); // Maximize the browser window

	            // Don't enter anything into the 'Search' text box field
	            WebElement searchBox = driver.findElement(By.name("search"));
	            searchBox.clear();

	            // Click on the button having search icon
	            WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
	            searchButton.click();

	            // Enter text from the product description into the 'Search Criteria' text box field
	            WebElement searchCriteriaBox = driver.findElement(By.id("input-search"));
	            String testData = "iLife";
	            searchCriteriaBox.sendKeys(testData);

	            // Select 'Search in product descriptions' checkbox option
	            WebElement searchInDescriptionCheckbox = driver.findElement(By.id("description"));
	            if (!searchInDescriptionCheckbox.isSelected()) 
	            {
	                searchInDescriptionCheckbox.click();
	            }

	            // Click on 'Search' button
	            WebElement searchCriteriaButton = driver.findElement(By.xpath("//input[@id='button-search']"));
	            searchCriteriaButton.click();

	            // Verify that product having the given text in its description is displayed in the search results
	            WebElement searchResult = driver.findElement(By.xpath("//a[text()='iMac']"));
	            if (searchResult.isDisplayed()) {
	                System.out.println("Test Passed: Product with description text '" + testData + "' is displayed in the search results");
	            } else {
	                System.out.println("Test Failed: No product with description text '" + testData + "' found in the search results");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
   }

}
