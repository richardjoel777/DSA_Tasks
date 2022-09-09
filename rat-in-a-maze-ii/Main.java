import java.util.*;

public class Main
{
    
    static boolean rat(int[][] a, int n, int i, int j, int[][] sol)
    {
        if(i == n-1 && j == n-1)
        {
            sol[i][j] = 1;
            return true;
        }
        
        if(i< 0 || i>= n || j<0 || j>=n || a[i][j] == 0)
            return false;
        
        sol[i][j] = 1;
        
        for(int k=1;k<=a[i][j];k++)
        {
            if(rat(a, n, i+k, j, sol))
                return true;
            if(rat(a, n, i, j+k, sol))
                return true;
        }
        
        sol[i][j] = 0;
        
        return false;
    }
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array size : ");
		
		int n = sc.nextInt();
		
		int[][] a = new int[n][n];
		
		System.out.println("Enter array elements space seperated");
		
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<n;j++)
		        a[i][j] = sc.nextInt();
		}
		
		int[][] sol = new int[n][n];
		
		if(rat(a, n, 0, 0, sol))
		{
    		System.out.println("Result is : ");
    		
    		for(int i=0;i<n;i++)
    		{
    		    for(int j=0;j<n;j++)
    		        System.out.print(sol[i][j] + " ");
    		    System.out.println();
    		}
		}
		else{
		    System.out.println("No Path Found");
		}
		
	}
}
