package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.LoginPage;

public class TestLogin {

	WebDriver driver;
	
	LoginPage objLoginPage;
	
	HomePage objHomePage;

	@BeforeMethod
	public void beforeMethod() {

		// Launch Chrome browser
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to the https://enterprise-demo.orangehrmlive.com/
		driver.get("https://enterprise-demo.orangehrmlive.com/");

		// set implicitly timeout to 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {

		// Close Chrome browser
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {

		// Set Chrome driver property
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver_2.25.exe");
	}
	
	@Test
	public void testLoginAsAdmin(){
		
		// Create Login Page object
		objLoginPage = new LoginPage(driver);
		
		// login to application
		objLoginPage.login("Admin", "admin");
		
		// Create Home Page object
		objHomePage = new HomePage(driver);
		
		// Verify user name after login
		Assert.assertTrue(objHomePage.getUserName().contains("Admin"));
	}

}
