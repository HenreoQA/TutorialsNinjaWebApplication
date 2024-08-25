package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_020 {

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
            
            // Click on 'Forgotten Password' option from the 'Right Column'
            driver.findElement(By.linkText("Forgotten Password")).click();

            // Verify that the user is navigated to the 'Forgotten Password' page
            String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/forgotten";
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.equals(expectedUrl)) {
                System.out.println("Test Passed: User is navigated to the 'Forgotten Password' page");
            } else {
                System.out.println("Test Failed: User is not navigated to the 'Forgotten Password' page. Actual URL: " + actualUrl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}

}
