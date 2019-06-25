package LinkConcept;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// set is an interface which extends collection interface
		//set doesnot allow duplicate values
		// set is unordered collection
		//can't be accessed using index
		
	/// HashSet,LinkedHashSet,TreeSet
		
		HashSet<String> hs=new HashSet<String>();
		 hs.add("selenium");
		 hs.add("java");
		 hs.add("qtp");
		 hs.add("23");
		 
		 System.out.println("print in unordered way"+hs);
		 
		 for(String i:hs)
		 {
			 System.out.println(i);
		 }
		 
		 LinkedHashSet<String> lhs= new LinkedHashSet<String>();
		 lhs.add("kulfi");
		 lhs.add("icecream");
		 lhs.add("chocolates");
		 System.out.println("print in insertion order"+lhs);
		 
		 
		 //convert set into List
		 
		 Set<String> hs1=new HashSet<String>();
		 hs1.add("selenium");
		 hs1.add("java");
		 hs1.add("qtp");
		 hs1.add("23");
		 
		 ArrayList<String> values=new ArrayList<String>(hs1);
		 
		 System.out.println("conver set into list"+values);
		 
		 System.out.println(values.get(2));
		 
		 
		 
	}
	

}
