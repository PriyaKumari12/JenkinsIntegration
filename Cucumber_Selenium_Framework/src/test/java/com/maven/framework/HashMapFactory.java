package com.maven.framework;

import java.util.HashMap;

public class HashMapFactory {
	
	private HashMapFactory()
	{}
	
	private static HashMapFactory comhashmapfactory=new HashMapFactory();
	 
	public static HashMapFactory getInstance()
	 {
		 return comhashmapfactory;
	 }
     
	ThreadLocal<HashMap<String,String>> mycontextThreadLocal=new ThreadLocal<HashMap<String,String>>()
	{
		@Override
		protected HashMap<String,String> initialValue()
		{
			return new HashMap<String,String>();
		}
	};
	
	public String getHashMapKey(String varkey)
	{
		return mycontextThreadLocal.get().get(varkey);
	}
	
	public void setHashMapKey(String varkey,String varval)
	{
		mycontextThreadLocal.get().put(varkey,varval);
	}
	
	public void removeHashMap()
	{
		mycontextThreadLocal.remove();
	}
}
