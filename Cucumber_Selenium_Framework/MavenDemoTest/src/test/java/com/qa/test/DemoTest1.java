package com.qa.test;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class DemoTest1 {
	
	@Test
    public void difference()
	{
	 System.out.println("difference");
	 int a=10;
	 int b=20;
	 Assert.assertEquals(10, b-a);
	}

}
