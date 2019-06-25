package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	// object repository
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//div[contains(text(),'Create a new account')]")
	WebElement facebooklogo;
	
	//initializing the page
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPage()
	{
		return driver.getTitle();
	}
	
	public boolean validatelogo()
	{
		return facebooklogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
	}

}
