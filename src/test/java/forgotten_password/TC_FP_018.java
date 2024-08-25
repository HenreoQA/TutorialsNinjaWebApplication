package forgotten_password;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_018 {

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
            
            // List of invalid email addresses to test
            List<String> invalidEmails = new ArrayList<>();
            invalidEmails.add("amotoori");
            invalidEmails.add("amotoori@");
            invalidEmails.add("amotoori@gmail");
            invalidEmails.add("amotoori@gmail.");

            for (String email : invalidEmails) {
                // Enter an invalid formatted email address into the 'E-Mail Address' field
                WebElement emailField = driver.findElement(By.id("input-email"));
                emailField.clear();  
                emailField.sendKeys(email);

                // Click on 'Continue' button to submit
                driver.findElement(By.xpath("//input[@value='Continue']")).click();

                // Verify the field level warning message
                WebElement warningMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
                
                String expectedWarning = "Warning: The E-Mail Address was not found in our records, please try again!";
                if (warningMessage.getText().contains(expectedWarning)) {
                    System.out.println("Test Passed for invalid email: " + email);
                } else {
                    System.out.println("Test Failed for invalid email: " + email);
                }
            }

        } catch (Exception e) 
        {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }

	}

}
