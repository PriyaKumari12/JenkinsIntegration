package handlers;

import java.util.HashMap;
import java.util.Map;

public class CountLetters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String value="When there is a will there is a way";
//		Map<Character,Integer> map = new HashMap<Character,Integer>();
//		char[] chararray=value.toCharArray();
//		for(Character c:chararray)
//		{
//			if(map.containsKey(c))
//			{
//				map.put(c, map.get(c)+1);
//			}
//			else
//			{
//				map.put(c, 1);
//			}
//		}
//		
//		System.out.println(map);
		
		int count=0;
		for(char i='a';i<='z';i++)
		{
		for(int j=0;j<value.length()-1;j++)
		{
		if(value.charAt(j)==i){
		count++;
		}
		}
		if(count!=0){
		System.out.println(i+"="+count);
		count=0;
		}
		}
		

	}

}
