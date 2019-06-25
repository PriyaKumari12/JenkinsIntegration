package Seleniumgluecode;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Test {
    public static WebDriver driver;
    @Given("^user is on homepage$")
    public void user_is_on_homepage() throws Throwable {     
    	System.setProperty("webdriver.chrome.driver", "/Users/Priya/Desktop/workspace/FreeCRM/chromedriver.exe");
		driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		
    }
    
    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();
    }
    
    @When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_username_and_Password(String username,String Password) throws Throwable {
    	driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();   
    }
    
    @Then("^success message is displayed$")
    public void success_message_is_displayed() throws Throwable {
    	String exp_message = "Welcome to your account. Here you can manage all   of your personal information and orders.";
    	String actual = driver.findElement(By.cssSelector(".info-account")).getText();
        Assert.assertEquals(exp_message, actual);
        driver.quit();  
    }      
}