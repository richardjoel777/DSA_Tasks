import java.util.*;

public class Main
{
    
    static int f(int house, int last, int[][]cost, int[][] dp){
        
        if (dp[house][last] != -1) return dp[house][last];

        if (house == 0) {
            int mini = Integer.MAX_VALUE;
            for (int i = 0; i <= 2; i++) {
                if (i != last)
                    mini = Math.min(mini, cost[0][i]);
            }
            return dp[house][last] = mini;
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int c = cost[house][i] + f(house - 1, i, cost, dp);
                mini = Math.min(mini, c);
            }
        }

        return dp[house][last] = mini;
    }
    
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter the number of houses");
	    
	    int n = sc.nextInt();
	    
		int[][] cost = new int[n][3];
		
		int[][] dp = new int[n][4];
		
		for(int[] r : dp)
		    Arrays.fill(r, -1);
		
		for(int i = 0; i<n; i++)
		{
		    System.out.println("Enter the cost of painting for red, green, blue");
		    for(int j=0;j<3;j++)
		        cost[i][j] = sc.nextInt();
		}
		
		int res = f(n-1, 3, cost, dp);
		
		System.out.println("Minimum cost is : " + res);
		
	}
}
