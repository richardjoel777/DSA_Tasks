import java.util.*;

public class Main
{
    static int f(int[] a, int i, int j, int[][] dp)
    {
        if(i == j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
            
        int mini = Integer.MAX_VALUE;
        
        for(int k=i;k<j;k++)
        {
            int op = a[i-1] * a[k] * a[j] + f(a, i, k, dp) + f(a, k+1, j, dp);
            
            mini = Math.min(mini, op);
        }
        
        return dp[i][j] = mini;
        
    }
    
    
    static int matrixMultiplication(int n, int a[])
    {
        int[][] dp = new int[n][n];
        
        for(int[] r : dp)
            Arrays.fill(r, -1);
        
        return f(a, 1, n-1, dp);
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array size");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		System.out.println("Enter array elements : ");
		
		for(int i=0;i<n;i++)
		    a[i] = sc.nextInt();
		
		System.out.println("Minimum Matrix Multiplication is " + matrixMultiplication(n, a));
	}
}

