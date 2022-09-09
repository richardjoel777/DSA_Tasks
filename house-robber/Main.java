import java.util.*;

public class Main
{
    
    static int robber(int[] nums, int n, int[] dp)
    {
        if(n == 0)
            return nums[n];
        if(n < 0)
            return 0;
        if(dp[n] != -1)
            return dp[n];
        int take = nums[n] + robber(nums,n-2,dp);
        int notTake = 0 + robber(nums,n-1,dp);
        
        return dp[n] = Math.max(take, notTake);
    }
    
    static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        return robber(nums, nums.length-1, dp);
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of the array");
		
		int n = sc.nextInt();

		
		int[] a = new int[n];
		
		System.out.println("Enter array elements : ");
		
		for(int i=0;i<n;i++)
		{
		        a[i] = sc.nextInt();
		}
		
		int res = rob(a);
		
		System.out.println("Maximum the robbr can rob without triggering the alarm is " + res);
	}
}
