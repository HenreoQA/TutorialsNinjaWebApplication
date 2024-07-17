package register_functionality;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.mail.*;
import javax.mail.search.FlagTerm;

import java.time.Duration;
import java.util.Properties;

public class TC_RF_002 
{
   
	public static void main(String[] args) 
	{
        WebDriver driver=new ChromeDriver(); //Launch chrome browser
        
       // WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
		
		driver.get("https://tutorialsninja.com/demo/"); //Open the application
		
		driver.manage().window().maximize(); //Maximise the page
		
        try {

            // Step 1: Click on 'My Account' Drop menu
        	 WebElement myAccountDropMenu = driver.findElement(By.xpath("//span[@class='caret']"));
             myAccountDropMenu.click();

            // Step 2: Click on 'Register' option
             WebElement registerOption = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
             registerOption.click();


            // Step 3: Enter new Account Details
             driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Henry");
             driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Agulanna");
            String email = "automationninja82@gmail.com";
            driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
            driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("01234567890");
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Password123");
            driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Password123");
            driver.findElement(By.xpath("//input[@name='agree']")).click();

            // Step 4: Click on 'Continue' button
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Step 5: Check the email address used for registering the account
           verifyEmail(email);

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            driver.quit();
        }
    }

    private static void verifyEmail(String email) 
    {
        try {
            // Mail server connection properties
            Properties properties = new Properties();
            properties.put("mail.store.protocol", "imaps");
            properties.put("mail.imap.host", "imap.gmail.com");
            properties.put("mail.imap.port", "993");
            properties.put("mail.imap.ssl.enable", "true");

            // Connect to the mail server
            Session emailSession = Session.getDefaultInstance(properties);
            Store store = emailSession.getStore("imaps");
            store.connect("imap.gmail.com", email, "blkvmiododmwtsgz"); // replace email password with App password

            // Open the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Search for unread emails
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            boolean found = false;
            for (Message message : messages) {
                if (message.getSubject().contains("Thank you for registering")) {
                    found = true;
                    System.out.println("Email Subject: " + message.getSubject());
                    System.out.println("Email From: " + message.getFrom()[0].toString());
                    System.out.println("Email Body: " + message.getContent().toString());

                    // Verify the email content and links
                    if (message.getContent().toString().contains("Thank you for registering")) {
                        System.out.println("Confirmation email is verified.");
                    } 
                    else 
                    {
                        System.out.println("Confirmation email content does not match.");
                    }

                    break;
                }
            }

            if (!found) {
                System.out.println("No confirmation email found.");
            }

            // Close the store and folder objects
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

