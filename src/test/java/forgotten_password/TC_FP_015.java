package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_015 {

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

            // Don't enter anything into the 'E-Mail Address' field
            driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("");

            // Click on 'Continue' button to attempt password reset
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Verify the field-level warning message
            WebElement warningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger"));
            String expectedMessage = "E-Mail must be between 4 and 20 characters!";
            String actualMessage = warningMessage.getText();

            if (actualMessage.contains(expectedMessage)) {
                System.out.println("Test Passed: Correct warning message is displayed");
            } else {
                System.out.println("Test Failed: Incorrect warning message is displayed. Actual message: " + actualMessage);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        } 
           

	}

}
