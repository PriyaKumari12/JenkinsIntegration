package com.maven.glue;


import com.maven.framework.loadTestData;

import cucumber.api.java.en.Given;

public class Global_StepDefinitions extends loadTestData
{	
	@Given("^TestData is loaded into HashMap \'([^\"]*)\',\'([^\"]*)\'$")
	public void LoadtestData(String TestDataPath,String sheetName) throws Exception
	{
	        loadTestDataInformation(TestDataPath,sheetName);
	}
	
}
