package search_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_SF_010 {

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
            
            // Select the parent category for the product in the 'Category' dropdown field
            Select categoryDropdown = new Select(driver.findElement(By.name("category_id")));
            categoryDropdown.selectByVisibleText("Desktops");

            // Click on the 'Search' button
            WebElement searchCriteriaButton = driver.findElement(By.id("button-search"));
            searchCriteriaButton.click();

            // Verify that 'There is no product that matches the search criteria' is displayed
            WebElement noResultsMessage = driver.findElement(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]"));
            if (noResultsMessage.isDisplayed()) {
                System.out.println("Test Passed: Correct message is displayed when subcategories are not selected");
            } else {
                System.out.println("Test Failed: Expected message not displayed when subcategories are not selected");
            }

            // Select 'Search in subcategories' checkbox field
            WebElement searchInSubcategoriesCheckbox = driver.findElement(By.name("sub_category"));
            if (!searchInSubcategoriesCheckbox.isSelected()) {
                searchInSubcategoriesCheckbox.click();
            }

            // Click on 'Search' button again
            driver.findElement(By.id("button-search")).click();

            // Verify that searched product is displayed in the search results
            WebElement searchResult = driver.findElement(By.xpath("//a[text()='iMac']"));
            if (searchResult.isDisplayed()) {
                System.out.println("Test Passed: Searched product is displayed in the search results when searching in subcategories");
            } else {
                System.out.println("Test Failed: Searched product is not displayed in the search results when searching in subcategories");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }


	}

}
