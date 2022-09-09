import java.util.*;

public class Main
{
    static int knapSack(int t, int w[], int v[], int n) 
    { 
        int[][] dp = new int[n][t+1];
        
        for(int i=w[0]; i<=t;i++)
            dp[0][i] = v[0];
            
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<=t;j++)
            {
                int notTaken = 0 + dp[i-1][j];
                int taken = 0;
                if(w[i] <= j)
                    taken = v[i] + dp[i-1][j-w[i]];
                dp[i][j] = Math.max(taken, notTaken);
            }
        }
        
        return dp[n-1][t];
    } 
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array size");
		int n = sc.nextInt();
		
		int[] w = new int[n];
		int[] v = new int[n];
		
		
		System.out.println("Enter Weights : ");
		
		for(int i=0;i<n;i++)
		    w[i] = sc.nextInt();
		
		System.out.println("Enter Values : ");
		
		for(int i=0;i<n;i++)
		    v[i] = sc.nextInt();
		    
		System.out.println("Enter Maximum Weight : ");
		
		int t = sc.nextInt();
		    
	    System.out.println("Maximum value can be obtained is " + knapSack(t, w, v, n));
	}
}
