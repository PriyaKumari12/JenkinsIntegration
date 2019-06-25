package LinkConcept;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListConcept {

	public static void main(String[] args) {
		
		LinkedList<String>  ll = new LinkedList<String>();
		
		ll.add("Test");
		ll.add("qtp");
		ll.add("Selenium");
		ll.add("uft");
		
		System.out.println("concept of linkedlist"+ll);
		
		//addfirst
		ll.addFirst("priya");
		ll.addLast("Automation");
		
		System.out.println("new vale:"+ll);
		
		//how to get and set the value
		
		System.out.println(ll.get(0));
		ll.set(0, "Tom");
		 System.out.println("new value againg"+ll);
		 
		 //remove first and last element
		 
		 ll.removeLast();
		 ll.removeFirst();
		 
		 System.out.println("after removing"+ll);
		 
		 ll.remove(1);
		 System.out.println("after removing from specific position"+ll);
		 
		 //print all the value of linkedlist
		 //for loop,advance loop,iterator,while
		 
		 System.out.println("for loop");
		 
		 for(int i=0;i< ll.size();i++)
		 {
			 System.out.println(ll.get(i));  
		 }
		 
		 System.out.println("using advance for loop");
		 
		 for(String str:ll)
		 {
			 System.out.println(str);
		 }
		 
		 System.out.println("using iterator");
		 
		 Iterator<String> it=ll.iterator();
		 while(it.hasNext())
		 {
			System.out.println(it.next()); 
		 }
		 
		 System.out.println("using while loop");
		 int num=0;
		 while(ll.size()>num)
		 {
			 System.out.println(ll.get(num));
			 num++;
		 }
	}
	

}
