package Demos;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Annotations {
  @Test(dataProvider="credentials")
  public void f(String username,String password) {
	  System.out.println(username);
	  System.out.println(password);
  }
  
  @DataProvider(name="credentials")
  public Object[][] getdata()
  {
	  Object[][] data= new Object[3][2];
	  
	  data[0][0]= "don1";
	  data[0][1]= "don1@gmail.com";
	  
	  data[1][0]= "don2";
	  data[1][1]= "don2@gmail.com";
	  
	  data[2][0]= "don3";
	  data[2][1]= "don3@gmail.com";
	  
	  return data;
	  
	  
  }
}
