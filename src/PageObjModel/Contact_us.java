package PageObjModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact_us {
	
	 private static WebElement element = null;
	 
	    public static WebElement contact_us(WebDriver driver){
	 
	         element = driver.findElement(By.id("contact-link"));
	 
	         return element;
	 
	         }
	 
	     public static WebElement subject_heading(WebDriver driver){
	 
	         element = driver.findElement(By.id("id_contact"));
	 
	         return element;
	 
	         }
	 
	     public static WebElement email_id(WebDriver driver){
	 
	         element = driver.findElement(By.id("email"));
	 
	         return element;
	 
	         }
	     public static WebElement order_id(WebDriver driver){
	    	 
	         element = driver.findElement(By.id("id_order"));
	 
	         return element;
	 
	         }
	     public static WebElement message_box(WebDriver driver){
	    	 
	         element = driver.findElement(By.id("message"));
	 
	         return element;
	 
	         }
	     public static WebElement submit_button(WebDriver driver){
	    	 
	         element = driver.findElement(By.id("submitMessage"));
	 
	         return element;
	 
	         }
	     
	     public static WebElement successfull_message(WebDriver driver){
	    	 
	         element = driver.findElement(By.xpath("//p[text()="
	 				+ "'Your message has been successfully sent to our team.']"));
	 
	         return element;
	 
	         }
	     public static WebElement expected_message(WebDriver driver){
	    	 
	         element = driver.findElement(By.xpath("//p[text()='Your message has "
	         		+ "been successfully sent to our team.']"));
	 
	         return element;
	 
	         }
}
