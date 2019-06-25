package LinkConcept;

public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr={10,20,50,60,80};
		int len=arr.length;
		
		
	 
		
		for (int i=0;i<len/2;i++)
		{
			int temp=arr[i];
			arr[i]=arr[len-i-1];
			arr[len-i-1]=temp;
		
			System.out.println(i + "  "+ arr[i]);
			
		}
		
		
		
		System.out.println("reversed array");
		for(int j=0;j<arr.length;j++)
		{
			System.out.println(arr[j]);
		}
		
		


		    

	}

}
