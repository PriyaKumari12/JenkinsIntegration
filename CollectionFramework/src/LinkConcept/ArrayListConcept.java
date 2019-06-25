package LinkConcept;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListConcept {

	public static void main(String[] args) {
		 
		
		int a[]= new int[3]; //static array--- size is fixed
		
		//dynamic array--arraylist
		//1.can contain multiple values
		//2.maintain insertion order
		//3.synchronised
		//4.allow random access to fetch the element because it stores the value on the basis on index
		
	
		ArrayList ar = new ArrayList();
		
		ar.add(10);
		ar.add(20);
		ar.add(30);
		ar.add(10);
		ar.add(40);
		ar.add("test");
		ar.add(10.25);
		
		System.out.println(ar.size());
		
		System.out.println(ar.get(4));
		
		///to print all values from arraylist
		//1. for loop
		//2. iterator
		
		for(int i=0;i<ar.size();i++)
		{
			System.out.println(ar.get(i));
			
		}
		
		
		ArrayList<String> ar1=new ArrayList<String>(); //generic arraylist
		ar1.add("Test");
		
		//employee class objects
		Employee emp=new Employee("Naveen",25,"QA");
		Employee emp1=new Employee("Naveen1",26,"QA1");
		Employee emp2=new Employee("Naveen2",28,"QA2");
		
		//create array list
		ArrayList<Employee> ar4=new ArrayList<Employee>();
		ar4.add(emp);
		ar4.add(emp1);
		ar4.add(emp2);
		
		//iterate through arraylist
		
		Iterator<Employee> it = ar4.iterator();
		
		while(it.hasNext())
		{
			Employee employee=it.next();
			System.out.println(employee.age);
			System.out.println(employee.dept);
			System.out.println(employee.name);
			
		}
		
		/// addAll()
		
		System.out.println("add all=========");
		
		ArrayList<String> arr=new ArrayList<String>(); //generic arraylist
		arr.add("Test");
		arr.add("Java");
		arr.add("Python");
		arr.add("Test");
		
		
		ArrayList<String> arr1=new ArrayList<String>(); //generic arraylist
		arr1.add("Test1");
		arr1.add("Java1");
		arr1.add("Python1");
		arr1.add("Test1");
		
		arr.addAll(arr1);
		
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
		
		//remove all
		System.out.println("remove all=========");
		
		arr.removeAll(arr1);
		for(int i=0;i<arr.size();i++)
		{
			System.out.println(arr.get(i));
		}
		
		
	}
	
	//example of method overloading
	public  static void main(String arg1)
	{
		
	}


}
