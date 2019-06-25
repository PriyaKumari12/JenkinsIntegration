package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginTestCase extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		loginpage = new LoginPage();
		
	}
		
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpage.ValidateLoginPage();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void FacebookLogoTest()
	{
		boolean flag = loginpage.validatelogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void login()
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}

}
