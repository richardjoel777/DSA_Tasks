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
        
        if(nums.length == 1)
            return nums[0];
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        
        int[] t1 = new int[nums.length-1];
        int[] t2 = new int[nums.length-1];
        
        int n = nums.length;
        
        for(int i=0;i<n-1;i++)
            t1[i] = nums[i];
        for(int i=1;i<n;i++)
            t2[i-1] = nums[i];
        
        int res1 = robber(t1, t1.length - 1, dp);
        
        Arrays.fill(dp, -1);
        
        int res2 = robber(t2, t2.length - 1, dp);
        
        return Math.max(res1, res2);
        
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
