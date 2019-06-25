package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	 public static Properties prop;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/Priya/Desktop/workspace/FreeCRM/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialization()
	{
		String browserName = prop.getProperty("Browser");
		
		if (browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/Priya/Desktop/workspace/FreeCRM/chromedriver.exe");

			driver=new ChromeDriver();
		}
		else if (browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/Priya/Desktop/workspace/FreeCRM/geckodriver.exe");

			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}	

}
