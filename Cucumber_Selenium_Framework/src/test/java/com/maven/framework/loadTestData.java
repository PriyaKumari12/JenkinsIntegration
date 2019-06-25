package com.maven.framework;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.maven.utility.Constants;

public class loadTestData {
	
	public HashMapFactoryEnv loadSetupInformation() throws Exception
	{		
		String varSearchbookPath=Constants.path_setup;
		String varSearchSheetName="SETUP";			
		File file = new File(varSearchbookPath);		
		FileInputStream fstream=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fstream);				
		XSSFSheet sheet = wb.getSheet(varSearchSheetName);
		int row_count=sheet.getPhysicalNumberOfRows();
		int column_count=sheet.getRow(0).getPhysicalNumberOfCells();
		try
		{  
			for(int i=1;i<row_count;i++)
			{
				String varTestParam=sheet.getRow(i).getCell(0).toString();
				System.out.println("rowcount "+row_count);
				if(varTestParam.equals("Y"))					
				{
					System.out.println("columncount "+column_count);
					for(int k=1;k<column_count;k++)
					{
						String varKey=sheet.getRow(0).getCell(k).toString();
						String varValue=sheet.getRow(i).getCell(k).toString();
						HashMapFactoryEnv.getInstance().setHashMapKeyEnv(varKey, varValue);	
						System.out.println(varKey + " " + varValue);
					}
					System.out.println("aftre fetching details");
					break;				
				}
			}
		System.out.println("Loading of setup data is completed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		return HashMapFactoryEnv.getInstance();
	}
	
	public HashMapFactory loadTestDataInformation(String sheetPath,String sheetName) throws Exception
	{		
		String varSearchbookPath=Constants.path_TestData+"\\"+sheetPath;
		String varScenarioName=HashMapFactory.getInstance().getHashMapKey("Scenario Name");
		File file = new File(varSearchbookPath);		
		FileInputStream fstream=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fstream);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int row_count=sheet.getPhysicalNumberOfRows();
		int column_count=sheet.getRow(0).getPhysicalNumberOfCells();
		try
		{  
			for(int i=1;i<row_count;i++)
			{
				String ActualParam=sheet.getRow(i).getCell(1).toString();
				
				String ActualScenarioName=sheet.getRow(i).getCell(0).toString();
				if(ActualScenarioName.equals(varScenarioName) && ActualParam.equals("Yes"))
				{
					for(int k=1;k<column_count;k++)
					{
						String varKey=sheet.getRow(0).getCell(k).toString();
						String varValue=sheet.getRow(i).getCell(k).toString();
						HashMapFactory.getInstance().setHashMapKey(varKey, varValue);
						System.out.println(varKey + " " + varValue);
					}				
				break;				
				}				
			}
			System.out.println("loading of test data is completed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		
		return HashMapFactory.getInstance();
	} 
	



}
