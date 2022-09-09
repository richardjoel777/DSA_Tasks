import java.util.*;

public class Main
{
    static int lis(int[] a) {
        
        int result = 1;
        int[] dp = new int[a.length + 1];
        Arrays.fill(dp, 1);
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < i; j++) {

                if(a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array size");
		int n = sc.nextInt();
		
		int[] a = new int[n];
		
		System.out.println("Enter Array values : ");
		
		for(int i=0;i<n;i++)
		    a[i] = sc.nextInt();
		    
	    System.out.println("Longest increasing subsequence is " + lis(a));
	}
}
