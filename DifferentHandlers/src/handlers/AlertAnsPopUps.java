package handlers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertAnsPopUps {
	
	public static void main(String[] args)
	{
		WebDriver driver= null;
		System.setProperty("webdriver.chrome.driver", "/Users/Priya/Desktop/workspace/FreeCRM/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("53920");
		driver.findElement(By.name("submit")).submit();
		
		Alert alert=driver.switchTo().alert();
		
		//capturing alert message
		String message= alert.getText();
		System.out.println(message);
		
		//accepting the alert
		//alert.accept();
		
		//not accepting the alert
		alert.dismiss();
	}

}
