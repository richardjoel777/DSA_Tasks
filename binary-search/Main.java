import java.util.*;

public class Main
{
    
    static int binarySearch(int[] a, int l, int h, int k)
    {
        if(l <= h)
        {
            int mid = l + (h-l)/2;
            
            if(a[mid] == k)
                return mid;
                
            if(a[mid] > k)
                return binarySearch(a, l, mid-1, k);
            
            return binarySearch(a, mid+1, h, k);
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
		 
		 int res = binarySearch(a, 0, n-1, k);
		 
		 if(res == -1)
		    System.out.println("Element is not found");
		 else
		    System.out.println("Element is found at " + res);
	}
}
