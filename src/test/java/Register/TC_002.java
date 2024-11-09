package Register;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_002 {

	public static void main(String[] args) throws MessagingException, IOException {
		
		// Launch chrome browser
		
		WebDriver driver = new ChromeDriver();
		
		// Implict wait
		
		driver. manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Open the application url
		
		driver.get("https://tutorialsninja.com/demo/");
		
		// maximize the page
		
		driver.manage().window().maximize();
		
	    
		// Click on my account dropdown
		
		driver.findElement(By.xpath("//span[@class='caret']")).click();
		
		// click on the register option
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		// Entering the new account details
		driver.findElement(By.id("input-firstname")).sendKeys("Henry");
		driver.findElement(By.id("input-lastname")).sendKeys("Agulanna");
		
		String email="testerpro@gmail.com";
		
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys("1234567");
		driver.findElement(By.id("input-password")).sendKeys("test@1234");
		driver.findElement(By.id("input-confirm")).sendKeys("test@1234");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		// verify email is sent
		verifyemail(email);
		
		driver.quit();
		
		
		
		}
	
	public static void verifyemail(String email) throws MessagingException, IOException
	{
		// Connecting to the mail server
		Properties prop = new Properties();
		 prop.put("mail.imap.host", "imap.gmail.com");
		 prop.put("mail.imap.port", "993");
		 prop.put("mail.imap.ssl.enable", "true");
		 
		 Session emailsession = Session.getDefaultInstance(prop);
		 Store store = emailsession.getStore("imaps");
		 store.connect("imap.gmail.com", email, "blkvmiododmwtsgz");
		 
		 //open inbox folder
		 
		 Folder inbox = store.getFolder("INBOX");
		 inbox.open(Folder.READ_ONLY);
		 
		 //search for unread emails
		 
		 Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

         boolean found = false;
         
         for(Message message: messages)
         {
        	 if(message.getSubject().contains("Thank you for registering")) {
        		 found =true;
        	 System.out.println("Email Subject:" + message.getSubject());
        	 System.out.println("Email body:" + message.getContent().toString());
        	 
        	 
        	 if(message.getContent().toString().contains("Thank you for registering"))
        	 {
        		 System.out.println("confirmation is verified");
        	 }
        	 else
        	 {
        		 System.out.println("confirmation message is not verified");
        	 }
        	 
        	 break;
         }
        	 
       }
         
         if(!found) {
        	 System.out.println("email was not found");
	}
         
         // Close the inbox folder
         
         inbox.close(false);
		store.close();
		

		
		}
	
	
	

}
