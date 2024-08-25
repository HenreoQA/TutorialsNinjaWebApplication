package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_019 {

	public static void main(String[] args) {
		
		// Launch the browser
        WebDriver driver = new ChromeDriver();
        // WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait

        try {
            // Open the Application URL and navigate to the Login Page
            driver.get("http://tutorialsninja.com/demo");
            driver.manage().window().maximize(); // maximise the page
            driver.findElement(By.xpath("//span[@class='caret']")).click();
            driver.findElement(By.linkText("Login")).click();

            // Click on 'Forgotten Password' link from the Login page
            driver.findElement(By.linkText("Forgotten Password")).click();
            
         // Click on 'Back' button on the 'Forgotten Password' page
            WebElement backButton = driver.findElement(By.linkText("Back"));
            backButton.click();

            // User should be taken to 'Login' page
            String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/login";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.equals(expectedUrl)) {
                System.out.println("Test Passed: User is successfully taken to the 'Login' page");
            } else {
                System.out.println("Test Failed: User is not taken to the 'Login' page. Actual URL: " + actualUrl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }


	}

}
