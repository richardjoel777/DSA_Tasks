import java.util.*;

public class Main
{
    static void swap(int[] a, int i, int j)
    {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    static int partition(int[] a, int start, int end)
    {
        int pivot = a[start];
        
        int l = start;
        int h = end;
        
        while(l < h)
        {
            while(a[l] <= pivot)
                l++;
            
            while(a[h] > pivot)
                h--;
            if(l < h)
                swap(a, l, h);
        }
        
        swap(a, start, h);
        
        return h;
    }
    
    static void quickSort(int[] a,int l,int h)
    {
        if( l < h)
        {
            int j = partition(a, l, h);
            quickSort(a, l, j-1);
            quickSort(a, j+1, h);
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
	        
	   quickSort(a, 0, n-1);
	   
	   System.out.println("Sorted array is : ");
	   
	   for(int i=0;i<n;i++)
	    System.out.print(a[i] + " ");
	}
}

