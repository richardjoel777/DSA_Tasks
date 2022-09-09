import java.util.*;

public class Main
{
    static int f(String s1, String s2, int i1, int i2,int[][] dp)
    {
        if(i1 < 0 || i2 < 0)
            return 0;
        
        if(dp[i1][i2] != -1)
            return dp[i1][i2];
        
        if(s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2] = 1 + f(s1, s2, i1-1, i2-1, dp);
        return dp[i1][i2] = (0 + Math.max(f(s1, s2, i1-1, i2, dp), f(s1, s2, i1, i2-1, dp)));
    }
    
    static int longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        
        for(int[] r : dp)
            Arrays.fill(r, -1);
        
        return f(s1, s2, s1.length()-1, s2.length()-1, dp);
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String : ");
		String s1 = sc.next();
		
		StringBuilder s2 = new StringBuilder();
        s2.append(s1);
        s2.reverse();
		
		System.out.println("Longest Common subsequence is : " + longestCommonSubsequence(s1, s2.toString()));
	}
}
