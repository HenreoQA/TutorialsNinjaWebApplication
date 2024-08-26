package search_functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_SF_003 {
	
	public static void main(String[] args) {
		
	   	 WebDriver driver=new ChromeDriver(); //Launch chrome browser
	     
	     // WebDriver driver = new EdgeDriver();
	      // WebDriver driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
			
	    try {
	        // Open the Application URL
	        driver.get("http://tutorialsninja.com/demo");
	        driver.manage().window().maximize(); // Maximize the browser window

	        // Do not enter any product name into the 'Search' text box
	        WebElement searchBox = driver.findElement(By.name("search"));
	        searchBox.sendKeys("");

	        // Click on the button having search icon
	        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
	        searchButton.click();

	        // Verify that no product is displayed in the search results
	        WebElement searchResult = driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]"));

	        if (searchResult.isDisplayed()) {
	            System.out.println("Test Passed: There is no product that matches the search criteria");
	        } else {
	            System.out.println("Test Failed");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Close the browser
	        driver.quit();
	    }

		}

	}



