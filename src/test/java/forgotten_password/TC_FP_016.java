package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_016 {

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
            
            // Locate the 'E-Mail Address' field
            WebElement emailField = driver.findElement(By.id("input-email"));

            // Verify the placeholder text for the 'E-Mail Address' field
            String expectedPlaceholder = "E-Mail Address";
            String actualPlaceholder = emailField.getAttribute("placeholder");

            if (expectedPlaceholder.equals(actualPlaceholder)) {
                System.out.println("Test Passed: Correct placeholder text is displayed");
            } else {
                System.out.println("Test Failed: Incorrect placeholder text is displayed. Actual: " + actualPlaceholder);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }


	}

}
