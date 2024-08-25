package forgotten_password;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_022 {

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
            
            // Enter email address into the 'E-Mail Address' field of the Login page
            String emailAddress = "automationninja82@gmail.com";
            WebElement emailField = driver.findElement(By.id("input-email"));
            emailField.sendKeys(emailAddress);

            // Click on 'Forgotten Password' link
            driver.findElement(By.linkText("Forgotten Password")).click();

            // Check if the email address is carried forward to the 'Forgotten Password' page
            WebElement forgottenPasswordEmailField = driver.findElement(By.id("input-email"));
            String carriedForwardEmail = forgottenPasswordEmailField.getAttribute("value");

            if (emailAddress.equals(carriedForwardEmail)) {
                System.out.println("Test Passed: Email address is carried forward to the 'Forgotten Password' page");
            } else {
                System.out.println("Test Failed: Email address is not carried forward correctly. Expected: " 
                                    + emailAddress + ", but found: " + carriedForwardEmail);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }

            


	}

}
