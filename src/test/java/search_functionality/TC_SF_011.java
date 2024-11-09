package search_functionality;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_SF_011 {

	public static void main(String[] args) {
		
WebDriver driver=new ChromeDriver(); //Launch chrome browser
        
        // WebDriver driver = new EdgeDriver();
         // WebDriver driver = new FirefoxDriver();
 		
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
 		
 		try {
            // Open the Application URL
            driver.get("http://tutorialsninja.com/demo");
            driver.manage().window().maximize(); // Maximize the browser window
            
            // Enter an existing product name into the 'Search' text box field
            WebElement searchBox = driver.findElement(By.name("search"));
            searchBox.sendKeys("iMac");

            // Click on the button having search icon
            driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

            // Select 'List' option
            WebElement listView = driver.findElement(By.xpath("//i[@class='fa fa-th-list']"));
            listView.click();

            // Check if the single product is displayed in List view with expected options
            verifyProductView(driver, "List");

            // Step 5: Click on the Image of the Product and name of the product
            navigateToProductPage(driver);

            // Repeat Steps 1 to 2 and Select 'Grid' option
            searchBox = driver.findElement(By.name("search"));
            searchBox.clear();
            searchBox.sendKeys("iMac");
            driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();

            // Verify ER-3: Select 'Grid' option
            WebElement gridView = driver.findElement(By.id("grid-view"));
            gridView.click();

            // Check if the single product is displayed in Grid view with expected options
            verifyProductView(driver, "Grid");

            // Step 6: Click on the Image of the Product and name of the product
            navigateToProductPage(driver);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to verify that the product is displayed correctly in List or Grid view
    public static void verifyProductView(WebDriver driver, String viewType) 
    {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-layout"));
        if (products.size() == 1) 
        {
            System.out.println("Test Passed: Single product is displayed in " + viewType + " view.");

            // Check if Add to Cart, Wish List, and Compare Product options are present
            WebElement addToCartButton = driver.findElement(By.xpath("//button[@data-original-title='Add to Cart']"));
            WebElement wishListButton = driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']"));
            WebElement compareButton = driver.findElement(By.xpath("//button[@data-original-title='Compare this Product']"));

            if (addToCartButton.isDisplayed() && wishListButton.isDisplayed() && compareButton.isDisplayed()) {
                System.out.println("All options (Add to Cart, Wish List, Compare Product) are working as expected in " + viewType + " view.");
            } else {
                System.out.println("Test Failed: Not all options are working in " + viewType + " view.");
            }
        } else {
            System.out.println("Test Failed: More than one product is displayed in " + viewType + " view.");
        }
    }

    // Method to navigate to the product display page by clicking on the product image or name
    public static void navigateToProductPage(WebDriver driver) {
        WebElement productImage = driver.findElement(By.cssSelector(".product-thumb .img-responsive"));
        WebElement productName = driver.findElement(By.cssSelector(".product-thumb h4 a"));

        // Click on the product image
        productImage.click();
        verifyNavigationToProductPage(driver);

        // Go back to the search results page
        driver.navigate().back();

        // Click on the product name
        productName.click();
        verifyNavigationToProductPage(driver);
    }

    // Method to verify navigation to the product display page
    public static void verifyNavigationToProductPage(WebDriver driver) {
        WebElement productTitle = driver.findElement(By.cssSelector("div#content h1"));
        if (productTitle.isDisplayed()) {
            System.out.println("Test Passed: User is navigated to the Product Display Page of the product.");
        } else {
            System.out.println("Test Failed: User is not navigated to the Product Display Page.");
        }


	}

}
