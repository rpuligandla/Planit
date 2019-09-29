/*Test Purpose: Planit test automation exercise
  Author: Ranjeeth Puligandla
  Version: 1
  Test Description: This script will test contact us and create a new account*/

package Planit_Tests;

import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.Assert;
import org.testng.ITestResult;

import PageObjModel.Contact_us;
import PageObjModel.Create_account;

public class contact_test {

	// Objects define
	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;

	// Below are paths to WEB, chromedriver and results file
	String chromeDriver = "C:\\Users\\Ranjeeth\\eclipse-workspace"
			+ "\\planit_exercise\\Supported_Files\\chromedriver.exe";
	String baseURL = "http://automationpractice.com/index.php";
	String resultsFile = "C:\\Users\\Ranjeeth\\eclipse-workspace\\planit\\reports\\extentreport.html";

	@BeforeSuite
	public void extentreport() {
		// extent report creation
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(resultsFile);
		System.out.println("New extent report creation started");
		extent = new ExtentReports();
		extent.attachReporter(reporter);

		// Detail of the Report Title, Name
		reporter.config().setDocumentTitle("Planit Report");
		reporter.config().setReportName("Your Logo");
	}

	@BeforeTest
	public void beforeTest() {
		//Launching browser and URL initiation
		System.out.println("Launching chrome browser");
		System.setProperty("webdriver.chrome.driver", chromeDriver);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@Test(priority = 1, description = "Test Page title")
	public void verifyHomepageTitle() {
		//Verifying the title of home page
		logger = extent.createTest("verifyHomepageTitle");
		String expectedTitle = "My Store";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("This is webpage Title : " + actualTitle);
	}

	@Test(priority = 2, description = "Test contact us page")
	public void contact_page() throws InterruptedException {
		//This test sends a contact message to the support team and checks it is working
		logger = extent.createTest("contact_page");
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-link")));
		System.out.println("Sending a query for support");
		
		/*Looking for contact-us link and then click 
		and sending values to the web elements */
		Contact_us.contact_us(driver).click();
		Select heading = new Select(Contact_us.subject_heading(driver));
		heading.selectByValue("2");
		Contact_us.email_id(driver).sendKeys("roger@email.com");
		Contact_us.order_id(driver).sendKeys("123CAD");
		Contact_us.message_box(driver).sendKeys("Im a new messages");
		Contact_us.submit_button(driver).click();
		Thread.sleep(50);
		//Verifying the output after the submit
		Contact_us.successfull_message(driver);
		String actualMessage = "Your message has been successfully sent to our team.";
		String ExpectedMessage = Contact_us.expected_message(driver).getText();
		Assert.assertEquals(actualMessage, ExpectedMessage);
	}

	@Test(priority = 3, description = "Test new user creation")
	public void createNewAccount() {

		//This test is to test the new account creation using an email address
		logger = extent.createTest("createNewAccount");
		String emailId = "test@test.com";
		System.out.println("Here we are going to create new account");
		Create_account.click_signin(driver).click();
		Create_account.enter_email(driver).sendKeys(emailId);
		Create_account.click_create(driver).click();

		//Verification of given email address accepted or not!
		WebElement fillForm = Create_account.error_message(driver);
		if (fillForm.isDisplayed()) {
			System.out.println("There is an account already exists with this email" + emailId);
		} else {
			System.out.println("Account can be created with => ' " + emailId + " ' <= email");
		}
	}

	@AfterTest(description = "Test ENDs here")
	public void afterTest() {
		//Closing the webDriver and test ends here
		driver.close();
	}

	@AfterMethod
	public void afterMethod(ITestResult results) {
		//Loggin the results of the test cases
		if (results.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed => " + results.getName());
		} else if (results.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed => " + results.getName());
		}
		extent.flush();
	}

}
