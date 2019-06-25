package handlers;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlers {
	
	public static void main(String[] args) throws ParseException{
	
	
	WebDriver driver;
	
	System.setProperty("webdriver.chrome.driver", "/Users/Priya/Desktop/workspace/FreeCRM/chromedriver.exe");

	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//navigate to the url	
//	driver.get("http://demo.guru99.com/test/web-table-element.php");
//	
//	List<WebElement> web=new ArrayList<WebElement>();
//	web=driver.findElements(By.xpath("//table[@class='dataTable']/thead/tr/th"));
//	System.out.println("no of columns present in the table"+web.size());
//	
//	List<WebElement> web1=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
//	System.out.println("no of rows present in the table"+web1.size());
//	
    
	// fetch all the value from webtable
	
/*	for (int i=1;i<=web1.size();i++)
	{
		for(int j=1;j<=web.size();j++)
		{
			String xpathvalue="//table[@class='dataTable']/tbody/tr/td["+j+"]";
			String element=driver.findElement(By.xpath(xpathvalue)).getText();
			System.out.println("value of ("+i+","+j+")"+element);
		}
	}
*/

	/*
	String valueOfRow1=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td[4]")).getText();
	Double m=Double.parseDouble(valueOfRow1);
	for(int i=1;i<web1.size();i++)
	{
		
		String valueOfRow2=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+(i+1)+"]/td[4]")).getText();			
		Double r=Double.parseDouble(valueOfRow2);		
		if(r>m)
		{
			m=r;
		}
		
	}	
	System.out.println(m);
	*/
	
	// get all the values of dynamic table(if no of rows and columns are different)
	
	
	//navigate to the url	
		driver.get("http://demo.guru99.com/test/table.html");
		
		List<WebElement> dynamicweb=new ArrayList<WebElement>();
		dynamicweb=driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		System.out.println("no of rows"+dynamicweb.size());
		
						
		for(int rows=0;rows<dynamicweb.size();rows++)
		{
			//to locate columns of specific row
			List<WebElement> dynamicwebcolumn=dynamicweb.get(rows).findElements(By.xpath("/html/body/table/tbody/tr["+(rows+1)+"]/td"));
			System.out.println("no of columns in row"+rows+":"+dynamicwebcolumn.size());
			
			for(int column=0;column<dynamicwebcolumn.size();column++)
			{
				String value=driver.findElement(By.xpath("/html/body/table/tbody/tr["+(rows+1)+"]/td["+(column+1)+"]")).getText();
				System.out.println("values:"+value);
			}
		}
	
		driver.close();
		driver.quit();
	
	}
}
