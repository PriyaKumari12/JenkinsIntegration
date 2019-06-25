package com.maven.page.object;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerCreationPage {
	
	private static By txt_Password=By.xpath("//input[@name='password']");
	private static By txt_userName=By.xpath("//input[@name='uid']");
	private static By btn_login=By.xpath("//input[@name='btnLogin]");	
	
	public void Login_Appliaction(WebDriver driver,String URL,String LoginId,String Password)
	{ 
		try{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 driver.findElement(txt_userName).sendKeys(LoginId);
		 driver.findElement(txt_Password).sendKeys(Password);
		 driver.findElement(btn_login).click();}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
	}

}
