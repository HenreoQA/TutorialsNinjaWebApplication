package forgotten_password;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_021 {

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
            
            // Verify the Breadcrumb on the 'Forgotten Password' page
            WebElement breadcrumb = driver.findElement(By.xpath("//ul[@class='breadcrumb']"));
            
            if (breadcrumb != null && breadcrumb.isDisplayed()) {
                System.out.println("Test Passed: Breadcrumb is displayed on the 'Forgotten Password' page");

                // Check if Breadcrumb contains proper links and text
                String breadcrumbText = breadcrumb.getText();
                System.out.println("Breadcrumb Text: " + breadcrumbText);

                // Expected text structure of the breadcrumb
                String expectedBreadcrumbText = "Account Forgotten Password";

                if (breadcrumbText.contains(expectedBreadcrumbText)) {
                    System.out.println("Test Passed: Breadcrumb text is correct");
                } else {
                    System.out.println("Test Failed: Breadcrumb text is incorrect");
                }

            } else {
                System.out.println("Test Failed: Breadcrumb is not displayed on the 'Forgotten Password' page");
            }

            // Verify that clicking on the 'Account' link in the breadcrumb works correctly
            WebElement AccountLink = driver.findElement(By.xpath("//a[text()='Account']"));
            AccountLink.click();
            String expectedAccountUrl = "https://tutorialsninja.com/demo/index.php?route=account/login";
            String actualAccountUrl = driver.getCurrentUrl();

            if (actualAccountUrl.equals(expectedAccountUrl)) {
                System.out.println("Test Passed: Clicking 'Account' in the breadcrumb navigates to the Account page");
            } else {
                System.out.println("Test Failed: Clicking 'Account' in the breadcrumb did not navigate to the Account page. Actual URL: " + actualAccountUrl);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }


	}

}
