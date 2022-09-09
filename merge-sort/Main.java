import java.util.*;

public class Main
{
    
    static void merge(int[] a,int l, int m, int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;
        
        int left[] = new int[n1];
        int right[] = new int[n2];
        
        for(int i=0;i<n1;i++)
            left[i] = a[l+ i];
        for(int i=0;i<n2;i++)
            right[i] = a[m + 1 + i];
        
        int i=0, j=0;
        
        int k = l;
        
        while(i < n1 && j < n2)
        {
            if(left[i] <= right[j])
                a[k++] = left[i++];
            else
                a[k++] = right[j++];
        }
        
        while(i < n1)
            a[k++] = left[i++];
        
        while(j<n2)
            a[k++] = right[j++];
    }
    
    static void mergeSort(int[] a, int l, int r)
    {
        if(l < r)
        {
            int mid = l + (r-l)/2;
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);
            
            merge(a, l, mid, r);
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the array size : ");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		System.out.println("Enter array elements");
		
		for(int i=0; i<n; i++)
		    a[i] = sc.nextInt();
		  
		 mergeSort(a, 0, n-1);
		 
		System.out.println("Sorted array is : ");
		
		for(int i=0; i<n; i++)
		    System.out.print(a[i] + " ");
	}
}
