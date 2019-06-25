package com.qa.test;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class DemoTest2 {
	
	@Test
    public void multiply()
	{
	 System.out.println("product");
	 int a=10;
	 int b=20;
	 Assert.assertEquals(200, a*b);
	}

}
