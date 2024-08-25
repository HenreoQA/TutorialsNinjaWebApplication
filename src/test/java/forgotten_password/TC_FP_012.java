package forgotten_password;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_012 {

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

            // Enter the email address of an existing account
            driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");

            // Click on 'Continue' button to request password reset
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Fetch the reset email
            String resetLink = fetchResetLinkFromEmail("automationninja@gmail.com", "emailpassword");

            if (resetLink != null) {
                // Navigate to the reset link
                driver.get(resetLink);

                // Verify Breadcrumb on the 'Reset your Password' page
                List<WebElement> breadcrumbItems = driver.findElements(By.xpath("//ul[@class='breadcrumb']/li/a"));

                // Expected Result: Verify that the breadcrumb is displayed and working
                if (!breadcrumbItems.isEmpty()) {
                    System.out.println("Test Passed: Breadcrumb is displayed on the 'Reset your Password' page");
                    for (WebElement item : breadcrumbItems) {
                        System.out.println("Breadcrumb Item: " + item.getText());
                    }

                    // Check if the breadcrumb links are working by clicking the first breadcrumb link
                    breadcrumbItems.get(0).click();
                    String expectedUrl = "http://tutorialsninja.com/demo/index.php?route=common/home";
                    String actualUrl = driver.getCurrentUrl();

                    if (actualUrl.equals(expectedUrl)) {
                        System.out.println("Test Passed: Breadcrumb is working correctly");
                    } else {
                        System.out.println("Test Failed: Breadcrumb link is not working correctly. Actual URL: " + actualUrl);
                    }
                } else {
                    System.out.println("Test Failed: Breadcrumb is not displayed on the 'Reset your Password' page");
                }
            } else {
                System.out.println("Test Failed: Reset link not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Fetch the password reset link from the email
    public static String fetchResetLinkFromEmail(String userEmail, String appPassword) {
        try {
            // Set up properties for the email session
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imaps.host", "imap.gmail.com");
            properties.put("mail.imaps.port", "993");
            properties.put("mail.imaps.ssl.enable", "true");

            // Connect to the mail server
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("imaps");
            store.connect("imap.gmail.com", userEmail, "blkvmiododmwtsgz"); // Replace with your app password

            // Open the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Search for the email with the subject related to password reset
            Message[] messages = inbox.search(new SubjectTerm("Password Reset"));

            for (Message message : messages) {
                if (message.getSubject().contains("Password Reset")) {
                    // Extract the email body and find the reset link
                    String content = message.getContent().toString();
                    String resetLink = extractResetLink(content);

                    if (resetLink != null) {
                        return resetLink;
                    }
                }
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Extract the reset link from the email body
    public static String extractResetLink(String content) {
        Pattern linkPattern = Pattern.compile("https?://\\S+resetPassword\\S+");
        Matcher matcher = linkPattern.matcher(content);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;



	}

}
