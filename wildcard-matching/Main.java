import java.util.*;

public class Main
{
    static boolean isAllStars(String S1, int i) {
        for (int j = 0; j <= i; j++) {
          if (S1.charAt(j) != '*')
            return false;
        }
        return true;
    }
    
    static int f(String S1, String S2, int i, int j, int[][] dp)
    {
        if (i < 0 && j < 0)
          return 1;
        if (i < 0 && j >= 0)
          return 0;
        if (j < 0 && i >= 0)
          return isAllStars(S1, i) ? 1 : 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
          return dp[i][j] = f(S1, S2, i - 1, j - 1, dp);
        if (S1.charAt(i) == '*')
          return dp[i][j] = (f(S1, S2, i - 1, j, dp) == 1 || f(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
        return dp[i][j] = 0;
    }
    
    static boolean isMatch(String s, String p) {
        
        int[][] dp = new int[p.length()][s.length()];
        
        for(int[] r : dp)
            Arrays.fill(r, -1);
        
        return f(p, s, p.length()-1, s.length()-1, dp) == 1;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String : ");
		String s1 = sc.next();
		
		System.out.println("Enter Pattern : ");
		String s2 = sc.next();
		
		if(isMatch(s1, s2))
		    System.out.println("It Matches");
		else
		    System.out.println("It doesn't match");
	}
}
