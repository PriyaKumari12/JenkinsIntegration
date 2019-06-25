package com.maven.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private DriverFactory()
	{}
	
	private static DriverFactory driverfactoryinstance=new DriverFactory();
	 
	public static DriverFactory getInstance()
	 {
		 return driverfactoryinstance;
	 }

	ThreadLocal<WebDriver> mycontextThreadLocal=new ThreadLocal<WebDriver>()
	{
	
	
	protected WebDriver initialValue()	
	{
		
		String BrowserVal=HashMapFactoryEnv.getInstance().getHashMapKeyEnv("BrowserName");
		
		if(BrowserVal.equalsIgnoreCase("CHROME"))
		{	
			System.out.println("chrome browser");
			System.setProperty("webdriver.chrome.driver", "C:\\selenium-java-3.4.0\\chromedriver.exe");		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
	        options.addArguments("--headless");
	        options.setExperimentalOption("useAutomationExtension", false);
	        options.addArguments("start-maximized"); // open Browser in maximized mode
	        options.addArguments("disable-infobars"); // disabling infobars
	        options.addArguments("--disable-extensions"); // disabling extensions
	        options.addArguments("--disable-gpu"); // applicable to windows os only
	        options.addArguments("--disable-dev-shm-usage"); 
			return new ChromeDriver(options);
		}
		
		else
		{ 
			return null;
		}
		}
	};
	
	public WebDriver getDriver()
	{
		System.out.println("Getting driver object");
		return mycontextThreadLocal.get();
	}
	
	public void removeDriver()
	{
		mycontextThreadLocal.get().quit();
	}
	
}
