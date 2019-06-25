package com.maven.glue;

import org.openqa.selenium.WebDriver;

import com.maven.framework.DriverFactory;
import com.maven.framework.HashMapFactory;
import com.maven.framework.HashMapFactoryEnv;
import com.maven.page.object.CustomerCreationPage;

import cucumber.api.java.en.When;

public class CustomerCreation {
	
	CustomerCreationPage ccp=new CustomerCreationPage();

	private static WebDriver driver=DriverFactory.getInstance().getDriver();
	
	@When("customer logs into application")
	public void login()
	{
		String URL=HashMapFactoryEnv.getInstance().getHashMapKeyEnv("URL");
		
		String LoginId=HashMapFactoryEnv.getInstance().getHashMapKeyEnv("UserName");
		String Password=HashMapFactoryEnv.getInstance().getHashMapKeyEnv("Password");
		System.out.println(URL +" "+ Password +" "+LoginId);
		ccp.Login_Appliaction(driver,URL,LoginId,Password);
	}
}
