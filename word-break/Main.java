import java.util.*;

public class Main
{
    static int f(String s, Set<String> d, int pos, int[] dp)
    {
        if(pos >= s.length())
            return 1;
        
        if(dp[pos] != -1)
            return dp[pos];
        
        for(int i=pos;i<s.length(); i++)
        {
            if(d.contains(s.substring(pos, i+1)) && f(s, d, i+1, dp) == 1)
                return dp[pos] = 1;   
        }
        return dp[pos] = 0;
    }
    
    static boolean wordBreak(String s, Set<String> d) {
        int n = s.length();
        
        int[] dp = new int[n];
        
        Arrays.fill(dp, -1);
        
        return f(s, d, 0, dp) == 1;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of strings in dictionary : ");
		int n = sc.nextInt();
		
		Set<String> st = new HashSet<>();
		
		System.out.println("Enter dictionary strins");
		
		for(int i=0;i<n;i++)
		    st.add(sc.next());
		    
		System.out.println("Enter the string to break : ");
		
		String s = sc.next();
		
		System.out.println(wordBreak(s, st));
		
	}
}
