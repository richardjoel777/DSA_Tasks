import java.util.*;

public class Main
{
    
    static int linearSearch(int[] a, int k)
    {
        for(int i=0; i<a.length; i++)
        {
            if(a[i] == k)
                return i;
        }
        
        return -1;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the array size : ");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		System.out.println("Enter array elements");
		
		for(int i=0; i<n; i++)
		    a[i] = sc.nextInt();
		  
		 System.out.println("Enter the element to search : ");
		 
		 int k = sc.nextInt();
		 
		 int res = linearSearch(a, k);
		 
		  if(res == -1)
		    System.out.println("Element is not found");
		 else
		    System.out.println("Element is found at " + res);
	}
}
