import java.util.*;

public class Main
{
    public static void sort(int[] a)
    {
        int n = a.length;
        
        for(int i=0;i<n;i++)
	   {
	       boolean f = true;
	       for(int j=0;j<n-1;j++)
	       {
	           if(a[j] > a[j+1])
	           {
	               int t = a[j];
	               
	               a[j] = a[j+1];
	               
	               a[j+1] = t;
	               
	               f = false;
	           }
	       }
	       
	       if(f)
	        break;
	   }
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter the size of the array : ");
	    
	    int n = sc.nextInt();
	    
	    int[] a = new int[n];
	    
	    System.out.println("Enter array elements : ");
	    
	    for(int i = 0; i < n; i++)
	        a[i] = sc.nextInt();
	        
	   sort(a);
	   
	   System.out.println("Sorted array is : ");
	   
	   for(int i=0;i<n;i++)
	    System.out.print(a[i] + " ");
	}
}

