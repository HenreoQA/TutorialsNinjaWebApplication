package forgotten_password;

import java.time.Duration;
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

public class TC_FP_008 {

    public static void main(String[] args) {

        // Launch the browser
           WebDriver driver = new ChromeDriver();
        // WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait
        driver.manage().window().maximize(); // maximize the page

        try {
            // Open the Application URL and navigate to the Login Page
            driver.get("http://tutorialsninja.com/demo");
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

                // Locate the 'Password' field
                WebElement passwordField = driver.findElement(By.id("input-password"));
                // Locate the 'Confirm' field
                WebElement confirmField = driver.findElement(By.id("input-confirm"));

                // Check if the placeholders are correct
                String expectedPasswordPlaceholder = "Password";
                String expectedConfirmPlaceholder = "Password Confirm";

                // Fetch actual placeholders
                String actualPasswordPlaceholder = passwordField.getAttribute("placeholder");
                String actualConfirmPlaceholder = confirmField.getAttribute("placeholder");

                // Validate the placeholders
                if (expectedPasswordPlaceholder.equals(actualPasswordPlaceholder) &&
                    expectedConfirmPlaceholder.equals(actualConfirmPlaceholder)) 
                {
                    System.out.println("Test passed: Correct placeholders are displayed");
                } else 
                {
                    System.out.println("Test failed: Incorrect placeholders are displayed");
                }
            } 
            else 
            {
                System.out.println("Test failed: Reset link not found.");
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            // Close the browser
            driver.quit();
        }
    }

    // Fetch the password reset link from the email
    public static String fetchResetLinkFromEmail(String userEmail, String password) {
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
        // Assuming the reset link is a URL, use a regex to extract it
        Pattern linkPattern = Pattern.compile("https?://\\S+resetPassword\\S+");
        Matcher matcher = linkPattern.matcher(content);

        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}