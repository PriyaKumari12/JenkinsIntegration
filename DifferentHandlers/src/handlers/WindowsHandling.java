package handlers;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=null;
		
		System.setProperty("webdriver.chrome.driver", "/Users/Priya/Desktop/workspace/FreeCRM/chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
        driver.get("http://demo.guru99.com/popup.php");	
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        
        String MainWindow=driver.getWindowHandle();	
        System.out.println(MainWindow);
        
        //to handle all new open windows
        
        Set<String> s1=driver.getWindowHandles();
                
        Iterator<String> I1=s1.iterator();
        
        while(I1.hasNext())
        {
       	String childwindow=I1.next();
        System.out.println(childwindow);
        
        	if (!MainWindow.equalsIgnoreCase(childwindow))
       	{
      		driver.switchTo().window(childwindow);
       		driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");                			
               driver.findElement(By.name("btnLogin")).click();
               System.out.println("tile:"+driver.switchTo().window(childwindow).getTitle());
                System.out.println("BaseUrl:"+driver.switchTo().window(childwindow).getCurrentUrl());
                driver.close();	
        		
       	}
       }
        
       //switching back to parent window
        driver.switchTo().window(MainWindow);

	}

}
