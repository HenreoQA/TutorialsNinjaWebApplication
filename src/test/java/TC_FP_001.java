package forgotten_password;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;

public class TC_FP_001
{

    public static void main(String[] args) {
        
    	//Launch the browser
           WebDriver driver = new ChromeDriver();
        // WebDriver driver = new EdgeDriver();
        // WebDriver driver = new FirefoxDriver();
           
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait

        try {
            //Open the Application URL
            driver.get("http://tutorialsninja.com/demo");
            
            driver.manage().window().maximize(); //maximise the page

            // Click on My Account and then Login
            WebElement myAccount = driver.findElement(By.xpath("//span[@class='caret']"));
            myAccount.click();
            WebElement loginLink = driver.findElement(By.linkText("Login"));
            loginLink.click();

            //Click on 'Forgotten Password' link
            WebElement forgottenPasswordLink = driver.findElement(By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']"));
            forgottenPasswordLink.click();

            // Expected Result: Verify user is taken to 'Forgotten Password' page
            if (driver.getTitle().contains("Forgot Your Password")) 
            {
                System.out.println("Passed: Navigated to Forgotten Password page.");
            } 
            else 
            {
                System.out.println("Failed: Not on Forgotten Password page.");
            }

            //Enter the email address of an existing account
            WebElement emailField = driver.findElement(By.id("input-email"));
            emailField.sendKeys("automationninja@gmail.com");

            //Click on 'Continue' button
            WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
            continueButton.click();

            // Expected Result: Verify the success message
            WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
            if (successMessage.getText().contains("An email with a confirmation link has been sent your email address.")) 
            {
            	
                System.out.println("Passed: Success message displayed.");
            } 
            else 
            {
                System.out.println("Failed: Success message not displayed.");
            }
            
            // Fetch the reset email
            String ResetLink = fetchResetLinkFromEmail("automationninja82@gmail.com", "emailpassword"); 

            if (ResetLink != null) 
            {
                // Navigate to the reset link
                driver.get(ResetLink);
                
                //  Reset the password
                WebElement passwordField = driver.findElement(By.id("input-password"));
                WebElement confirmPasswordField = driver.findElement(By.id("input-confirm"));
                passwordField.sendKeys("12345");
                confirmPasswordField.sendKeys("12345");
                driver.findElement(By.xpath("//input[@value='Continue']")).click();

                // Validate the password reset was successful
                WebElement successmessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
                if (successmessage.getText().contains("Your password has been successfully updated")) 
                {
                    System.out.println("Password reset was successful");
                } 
                else 
                {
                    System.out.println("Password reset failed");
                }
            } 
            else 
            {
                System.out.println("Reset link not found in email");
            }
            
            //Enter the email and new password, then login
            driver.findElement(By.id("input-email")).sendKeys("automationninja@gmail.com");
            driver.findElement(By.id("input-password")).sendKeys("12345");
            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Continue']"));
            loginButton.click();

            // Verify user should be able to login with the new password
            WebElement accountDashboard = driver.findElement(By.xpath("//h2[text()='My Account']"));
            if (accountDashboard.isDisplayed()) 
            {
            	
                System.out.println("Passed: User logged in successfully with new password");
            } 
            else 
            {
                System.out.println("Failed");
            }


        } catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            // Close browser
            driver.quit();
        }
    }

   
     //Fetch the password reset link from the email.
     
    public static String fetchResetLinkFromEmail(String userEmail, String password) 
    {
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
            store.connect("imap.gmail.com", "automationninja82@gmail.com", "blkvmiododmwtsgz"); // replace email password with App password


            // Open the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Search for the email with the subject related to password reset
            Message[] messages = inbox.search(new SubjectTerm("Password Reset"));

            for (Message message : messages) {
                if (message.getSubject().contains("Password Reset")) 
                {
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
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return null;
    }

    
     // Extract the reset link from the email body.
     
    public static String extractResetLink(String content) 
    {
        // Assuming the reset link is a URL, use a regex to extract it
        Pattern linkPattern = Pattern.compile("https?://\\S+resetPassword\\S+");
        Matcher matcher = linkPattern.matcher(content);

        if (matcher.find()) 
        {
            return matcher.group();
        }
        return null;
           
    }
    
    
}


	