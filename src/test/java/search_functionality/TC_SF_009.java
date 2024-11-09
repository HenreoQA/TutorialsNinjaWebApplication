package search_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_SF_009 {

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

            //  Enter any Product Name into the 'Search Criteria' text box field 
            String productname = "iMac";
            driver.findElement(By.id("input-search")).sendKeys(productname);
            
            // Select the correct category for the product in the 'Category' dropdown field
            WebElement categoryDropdown = driver.findElement(By.xpath("//select[@name='category_id']"));
            Select Options= new Select(categoryDropdown);
            Options.selectByValue("27");

            // Click on the 'Search' button
            driver.findElement(By.id("button-search")).click();

            // Verify that product is successfully displayed in the search results
            WebElement searchResult = driver.findElement(By.xpath("//a[text()='iMac']"));
            if (searchResult.isDisplayed()) {
                System.out.println("Test Passed: Product is successfully displayed in the search results");
            } else {
                System.out.println("Test Failed: Product is not displayed in the search results");
            }

            // Select a wrong category in the 'Category' dropdown field
            WebElement Dropdown = driver.findElement(By.xpath("//select[@name='category_id']"));
            Select Option= new Select(Dropdown);
            Option.selectByValue("26");

            // Click on 'Search' button
            driver.findElement(By.id("button-search")).click();

            // Verify that 'There is no product that matches the search criteria' is displayed
            WebElement noResultsMessage = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria.')]"));
            if (noResultsMessage.isDisplayed()) {
                System.out.println("Test Passed: Correct message displayed for wrong category selection");
            } else {
                System.out.println("Test Failed: Expected message not displayed for wrong category selection");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }

	}

}
