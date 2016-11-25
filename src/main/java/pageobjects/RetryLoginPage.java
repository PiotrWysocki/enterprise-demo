package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetryLoginPage {
	
	WebDriver driver;	
	
	// Find user name textbox 
	@FindBy(id="txtUsername")
	WebElement txtUsername;
	
	// Find password textbox 
	@FindBy(id="txtPassword")
	WebElement txtPassword;
	
	// Find login button 
	@FindBy(id="btnLogin")
	WebElement btnLogin;
	
	// Find heading
	@FindBy(xpath="//*[@id='content']//h1")
	WebElement heading;
	
	public RetryLoginPage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	// Set user name in textbox
	public void setUserName(String strUserName){
		txtUsername.sendKeys(strUserName);
	}
	
	// Set password in textbox
	public void setPassword(String strPassword){
		txtPassword.sendKeys(strPassword);
	}
	
	// Click on login button
	public void clickLogin(){
		btnLogin.click();
	}
	
	// Get heading
	public String getHeading(){
		return heading.getText();
	}

}
