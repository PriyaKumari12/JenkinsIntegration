package LinkConcept;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//interface,support key value pair
		//contains only unique key
		//easy to do search,update or delete elements on the basis of key
		
		
		//hashmap-- allowas one null key and multiple null values
		            // doesnot store value in order
		
		HashMap<String,String> hm=new HashMap<>();
		hm.put("401", "Mukesh");
		hm.put("402", "Otwani");
		hm.put("403", "Naveen");
		hm.put("404", "Automation");
		hm.put("405", "Lab");
		
		System.out.println("key value pair"+hm);
		
		String value=hm.get("401");
		System.out.println("value of the key"+value);
		
		String value1=hm.get("900");
		System.out.println("value of key not present"+value1);
		
		
		for(Map.Entry<String, String> data : hm.entrySet())
		{
			
			System.out.println("key value is:"+data.getKey()+"the value of key is:"+data.getValue());
		}
		
		
		

	}

}
