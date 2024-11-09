package forgotten_password;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import java.util.Properties;

public class AmazonForgotPassword {

    public static void main(String[] args) throws InterruptedException {
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the Application URL
            driver.get("https://www.amazon.co.uk/");
            driver.manage().window().maximize();
            
            //Handling cookies
            driver.findElement(By.id("sp-cc-rejectall-link")).click();

            // Click on sign-in button
            WebElement signInButton = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
            signInButton.click();

            // Enter email address
            WebElement emailBox = driver.findElement(By.id("ap_email"));
            emailBox.sendKeys("automationninja82@gmail.com");

            // Click on continue button
            WebElement continueButton = driver.findElement(By.id("continue"));
            continueButton.click();

            // Click on forgotten password link
            WebElement forgotPasswordLink = driver.findElement(By.id("auth-fpp-link-bottom"));
            forgotPasswordLink.click();

            //  Enter email address of an existing account
            WebElement forgotEmailBox = driver.findElement(By.id("ap_email"));
            forgotEmailBox.clear();
            forgotEmailBox.sendKeys("automationninja82@gmail.com");

            // Click on continue button
            WebElement forgotContinueButton = driver.findElement(By.id("continue"));
            forgotContinueButton.click();

            // Wait for the email to be sent
            Thread.sleep(5000);

            // Verify Email
            verifyResetPasswordEmail("automationninja82@gmail.com", "blkvmiododmwtsgz");  //replace email password with App password

        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to verify the reset password email
    public static void verifyResetPasswordEmail(String email, String password) 
    {
        try {
        	 // Create properties for the IMAP session
            Properties props = new Properties();
            props.put("mail.store.protocol", "imaps");

            // Initialize email session
            Session session = Session.getDefaultInstance(props, null);
            
         // Create an IMAP store and connect to gmail
            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", email, password);

            // Access the inbox folder in read-only mode
            Folder inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_ONLY);

            // Search for the unread messages
            Message[] messages = inbox.getMessages();
            
            //Using enhanced for loop to print the details
            for (Message message : messages) 
            {
                String subject = message.getSubject();
                if (subject.contains("Password recovery")) {
                    System.out.println("Password reset email is found");

                  
                    // Validate email body and from address
                    String from = message.getFrom()[0].toString();
                    if (from.contains("account-update@amazon.co.uk")) {
                        System.out.println("From address is correct.");
                    } else {
                        System.out.println("Incorrect from address.");
                    }
                    
                    
                    // Verify email body content
                    if (message.isMimeType("multipart/*")) {
                        MimeBodyPart part = (MimeBodyPart) ((Multipart) message.getContent()).getBodyPart(0);
                        String body = part.getContent().toString();
                   
                    if (body.contains("Someone is attempting to reset your account’s password")) {
                        System.out.println("Email body contains correct reset message.");
                    } else {
                        System.out.println("Email body does not contain correct reset message.");
                    }
                    }

                    break;
                }
            }

            // Close the connections
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

      }

