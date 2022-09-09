import java.util.*;

public class Main
{
    static int trap(int[] a) {
        int n=a.length;
        int l=0,r=a.length-1;
		int lmax=0,rmax=0,res=0;
		while(l<r){
            if(a[l]<=a[r])
            {
                if(a[l]>lmax)
                    lmax=a[l];
                else
                    res+=lmax-a[l];
                l++;
            }
            else
            {
                if(a[r]>rmax)
                    rmax=a[r];
                else
                    res+=rmax-a[r];
                r--;
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of blocks : ");
		
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		System.out.println("Enter heights : ");
		
		for(int i=0; i<n; i++)
		    a[i] = sc.nextInt();
		    
	   int res = trap(a);
	   
	   System.out.println("Maximum trapped water is : " + res);
		
	}
}

