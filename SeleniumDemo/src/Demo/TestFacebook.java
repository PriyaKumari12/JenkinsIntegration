package Demo;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestFacebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hgsjhgs");
		//System.setProperty("webdriver.gecko.driver", "drive_path//geckodriver.exe");

		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='u_0_j']")).sendKeys("TEstSelenium");
		
		//*[@id="u_0_9"]
		driver.findElement(By.xpath("//*[@id='u_0_9']")).click();


	}

}




