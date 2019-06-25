package com.maven.glue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.maven.framework.DriverFactory;
import com.maven.framework.HashMapFactory;
import com.maven.framework.loadTestData;
import com.maven.utility.Log;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAndAfterScenario extends loadTestData{
	
	public static String ScenarioName="";
	public static Scenario varScenarioName;
	
	
	@Before
	public void beforeScenario(Scenario scenario) throws Exception
	{
		DOMConfigurator.configure("log4j.xml");
		varScenarioName=scenario;
		ScenarioName=scenario.getName();
		System.out.println(ScenarioName);
		HashMapFactory.getInstance().setHashMapKey("Scenario Name", ScenarioName);	
		System.out.println(HashMapFactory.getInstance().getHashMapKey("Scenario Name"));
		Log.startTestCasename(ScenarioName);
		loadSetupInformation();
		System.out.println("Completed execution of before method");
	}
	
	@After
	public void afterscenario(Scenario scenario)
	{
		try{
		WebDriver driver=DriverFactory.getInstance().getDriver();
		Log.endTestCase();
		if(scenario.isFailed())
		{
			byte[] screenshotsBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotsBytes, "image/png");
		}}
		catch(Exception e)
		{
			System.out.println("Exceptional: "+ e);
		}
		
	}

}
