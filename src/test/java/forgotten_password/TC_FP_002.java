package forgotten_password;

import java.time.Duration;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_FP_002 {

	public static void main(String[] args) {
		

    	//Launch the browser
           WebDriver driver = new ChromeDriver();
        // WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();
           
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait


	        try {
             // Open the Application URL and navigate to Login Page
	            driver.get("http://tutorialsninja.com/demo");
	            driver.manage().window().maximize(); //maximise the page
	            driver.findElement(By.xpath("//span[@class='caret']")).click();
	            driver.findElement(By.linkText("Login")).click();

	            //Click on 'Forgotten Password' link
	            driver.findElement(By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']")).click();

	            //Enter the email address of an existing account
	            driver.findElement(By.id("input-email")).sendKeys("automationninja82@gmail.com");

	            //Click on 'Continue' button
	            driver.findElement(By.xpath("//input[@value='Continue']")).click();

	            // Check the email
	            boolean emailReceived = checkEmailForPasswordReset("automationninja82@gmail.com", "new_password_link");

	            if (emailReceived) 
	            {
	                System.out.println("Email received with proper details and reset link.");
	            } 
	            else 
	            {
	                System.out.println("Failed to receive the expected email.");
	            }

	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	        } 
	        finally 
	        {
	            // Close the browser
	            driver.quit();
	        }
	    }

	    public static boolean checkEmailForPasswordReset(String emailAddress, String expectedLinkKeyword) 
	    {
	        // Set email properties
	        Properties props = new Properties();
	        props.put("mail.store.protocol", "imaps");

	        try {
	            // Connect to the email server
	            Session session = Session.getDefaultInstance(props, null);
	            Store store = session.getStore("imaps");
	            store.connect("imap.gmail.com", "automationninja82@gmail.com", "blkvmiododmwtsgz"); // replace email password with App password

	            // Open the inbox folder
	            Folder inbox = store.getFolder("inbox");
	            inbox.open(Folder.READ_ONLY);

	            // Search for the email with a specific subject
	            Message[] messages = inbox.search(new SubjectTerm("Password Reset"));

	            for (Message message : messages) {
	                if (message.getFrom()[0].toString().contains("no-reply@tutorialsninja.com")) 
	                {
	                    String emailContent = message.getContent().toString();
	                    if (emailContent.contains(expectedLinkKeyword)) {
	                        System.out.println("Subject: " + message.getSubject());
	                        System.out.println("From: " + message.getFrom()[0]);
	                        System.out.println("Content: " + emailContent);
	                        return true; // Email found with expected content
	                    }
	                }
	            }

	            // Close the connections
	            inbox.close(false);
	            store.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return false; // Email not found or incorrect content

	}

}
