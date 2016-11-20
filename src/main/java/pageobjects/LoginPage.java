package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
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
	
	public LoginPage(WebDriver driver){
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
	
	public void login(String strUserName, String strPassword){
		
		// Fill user name
		this.setUserName(strUserName);
		
		// Fill password
		this.setPassword(strPassword);
		
		// Click login button
		this.clickLogin();
		
	}

}
