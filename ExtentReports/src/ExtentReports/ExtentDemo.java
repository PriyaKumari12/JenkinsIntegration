package ExtentReports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class ExtentDemo {
	
			static ExtentTest test;
			static ExtentReports report;
		
			
			
			
			@BeforeClass
			public static void startTest()
			{
				System.out.println(System.getProperty("user.dir"));
				report = new ExtentReports(System.getProperty("user.dir")+"/test-Output/ExtentReportResults.html",true);
				test = report.startTest("ExtentDemo");
				
				
			}
			
			
			
			@Test
			public void extentReportsDemo() throws IOException
			{

				System.setProperty("webdriver.chrome.driver","/Users/Priya/Desktop/workspace/ExtentReports/chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.google.co.in");
				if(driver.getTitle().equals("Googles"))
				{
					test.log(LogStatus.PASS, "Navigated to the specified URL");
				}
				else
				{
					System.out.println("test failed");
					test.log(LogStatus.FAIL, "Test Failed");;
					test.log(LogStatus.FAIL,test.addScreenCapture(capture(driver))+ "Test Failed");
		
				
					}
				}
			
		
			@AfterClass
			public static void endTest()
			{
				report.endTest(test);
				report.flush();
			}
			
			
			public static String capture(WebDriver driver) throws IOException {
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()+ ".png");
				String errflpath = Dest.getAbsolutePath();
				FileUtils.copyFile(scrFile, Dest);
				return errflpath;
				}
			
}
