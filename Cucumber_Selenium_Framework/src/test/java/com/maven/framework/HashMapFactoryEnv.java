package com.maven.framework;

import java.util.HashMap;

public class HashMapFactoryEnv {
	
	private HashMapFactoryEnv()
	{}
	
	private static HashMapFactoryEnv instance=new HashMapFactoryEnv();
	 
	public static HashMapFactoryEnv getInstance()
	 {
		 return instance;
	 }
     
	ThreadLocal<HashMap<String,String>> mycontextThreadLocal=new ThreadLocal<HashMap<String,String>>()
	{
		@Override
		protected HashMap<String,String> initialValue()
		{
			return new HashMap<String,String>();
		}
	};
	
	public String getHashMapKeyEnv(String varkey)
	{
		return mycontextThreadLocal.get().get(varkey);
	}
	
	public void setHashMapKeyEnv(String varkey,String varval)
	{
		mycontextThreadLocal.get().put(varkey,varval);
	}
	
	public void removeHashMap()
	{
		mycontextThreadLocal.remove();
	}


}
