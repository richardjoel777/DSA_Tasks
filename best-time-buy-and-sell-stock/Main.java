import java.util.*;

public class Main
{
    static int maxProfit(int k, int[] a) {
        int n = a.length;
        
        int[][] ahead = new int[2][k+1];
        int[][] curr = new int[2][k+1];
        
        for(int i=n-1; i>=0; i--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=k;cap++)
                {
                    if(buy == 1)
                       curr[buy][cap] = Math.max(-a[i] + ahead[0][cap], 0 + ahead[1][cap]);
                    else
                        curr[buy][cap] = Math.max(a[i] + ahead[1][cap-1], 0 + ahead[0][cap]);
                }
            }
            ahead = curr;
        }
        
        return ahead[1][k];
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array size");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		System.out.println("Enter Profits : ");
		
		for(int i=0;i<n;i++)
		    a[i] = sc.nextInt();
		  
		 System.out.println("Enter Maximum number of transactions : ");
		 int k = sc.nextInt();
		    
		 System.out.println("Maximum Profit is : " + maxProfit(k, a));
	}
}

