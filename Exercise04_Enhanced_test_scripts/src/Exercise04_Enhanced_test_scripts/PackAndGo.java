package Exercise04_Enhanced_test_scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.ExcelUtility;

public class PackAndGo {
	WebDriver driver;
	
	@Before
	public void setup() throws IOException
	{	
		System.setProperty("webdriver.chrome.driver", "/Users/Priya/Desktop/workspace/FreeCRM/chromedriver.exe");
		driver=new ChromeDriver();
		
		//navigate to AUT
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				
		ExcelUtility.setExcelFile();
		
		
	}
	
	@Test
	public void aUT() throws IOException
	{
		
			String sUserName = ExcelUtility.getCellValue(1, 0);	
			System.out.println("username:"+sUserName);
			String sPassword = ExcelUtility.getCellValue(1, 1);
			System.out.println("password:"+sPassword);
			driver.findElement(By.name("uid")).sendKeys(sUserName);
			driver.findElement(By.name("password")).sendKeys(sPassword);
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try{
				FileUtils.copyFile(scrFile, new File("/Users/Priya/Desktop/workspace/Exercise04_Enhanced_test_scripts/Image1.png"));
			} catch(IOException e){
				System.out.println("Exception Message: " + e.getMessage());
			}	

			driver.findElement(By.name("btnLogin")).click();
			
			Alert alert=driver.switchTo().alert();
			alert.accept();
				
		
	}
	
	
	@Test
	public void aUT1() throws IOException
	{
		
			String sUserName = ExcelUtility.getCellValue(2, 0);	
			System.out.println("username:"+sUserName);
			String sPassword = ExcelUtility.getCellValue(2, 1);
			System.out.println("password:"+sPassword);
			driver.findElement(By.name("uid")).sendKeys(sUserName);
			driver.findElement(By.name("password")).sendKeys(sPassword);
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try{
				FileUtils.copyFile(scrFile, new File("/Users/Priya/Desktop/workspace/Exercise04_Enhanced_test_scripts/Image.png"));
			} catch(IOException e){
				System.out.println("Exception Message: " + e.getMessage());
			}	

			driver.findElement(By.name("btnLogin")).click();
			
			Alert alert=driver.switchTo().alert();
			alert.accept();
						
		
		
	}
	
	@After
	public void afterAUT()
	{
		driver.close();
	}
	

}
