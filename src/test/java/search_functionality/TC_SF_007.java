package search_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_SF_007 {

	public static void main(String[] args) {
		
		 WebDriver driver=new ChromeDriver(); //Launch chrome browser
	        
	        // WebDriver driver = new EdgeDriver();
	         // WebDriver driver = new FirefoxDriver();
	 		
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
	 		
	 		try {
	            // Open the Application URL
	            driver.get("http://tutorialsninja.com/demo");
	            driver.manage().window().maximize(); // Maximize the browser window

	            // Don't enter anything into the 'Search' text box field and click the search icon
	            WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
	            searchButton.click();

	            // Enter an existing product name into the 'Search Criteria' text box field
	            String testData = "iMac";
	            WebElement searchCriteriaBox = driver.findElement(By.id("input-search"));
	            searchCriteriaBox.clear();
	            searchCriteriaBox.sendKeys(testData);

	            // Click on the 'Search' button
	            WebElement searchCriteriaButton = driver.findElement(By.xpath("//input[@id='button-search']"));
	            searchCriteriaButton.click();

	            // Searched product should be displayed in the search results
	            WebElement searchResult = driver.findElement(By.linkText("iMac"));

	            if (searchResult.isDisplayed()) {
	                System.out.println("Test Passed: Searched product '" + testData + "' is displayed in the search results");
	            } else {
	                System.out.println("Test Failed: Searched product '" + testData + "' is not displayed in the search results");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }

	}

}
