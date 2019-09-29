package PageObjModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Create_account {
	
	 private static WebElement element = null;
	 
	    public static WebElement click_signin(WebDriver driver){
	 
	         element = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
	 
	         return element;
	 
	         }
	    public static WebElement enter_email(WebDriver driver){
	   	 
	         element = driver.findElement(By.id("email_create"));
	 
	         return element;
	 
	         }
	    public static WebElement click_create(WebDriver driver){
		   	 
	         element = driver.findElement(By.id("SubmitCreate"));
	 
	         return element;
	 
	         }
	    public static WebElement error_message(WebDriver driver){
		   	 
	         element = driver.findElement(By.id("create_account_error"));
	 
	         return element;
	 
	         }
}
