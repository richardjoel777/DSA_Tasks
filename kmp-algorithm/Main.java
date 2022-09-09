import java.util.*;

class Main
{
    static void pat(char[] s, int[] lps) 
    {
        int j=0,i=1;
		lps[0] = 0;
		while(i<s.length)
		{
		    if(s[j] == s[i])
		    {
		        lps[i] = j++;
		        i++;
		    }
		    else
		    {
		        if(j==0)
		        {
		            lps[i]=0;
		            i++;
		        }
		        else
		        {
		            j = lps[j-1];
		        }
		    }
		}
    }
    
    static void kmp(String s1, String s2, int[] lps)
    {
		int i=0,j=0;
		int n = s2.length();
		int m = s1.length();
		char[] s = s1.toCharArray();
        char[] p = s2.toCharArray();
        while(i < m)
		{
		    if(p[j] == s[i])
		    {
		        i++;
		        j++;
		    }
		    if(j == n)
		    {
		        System.out.println("Pattern found at : " + (i-j));
		        j = lps[j-1];
		    }
		    else if(i<m && p[j] != s[i])
		    {
		        if(j!=0)
		            j = lps[j-1];
		        else
		            i++;
		    }
		}
    }
    
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter the string : ");
	    
	    String s = sc.next();
	    
	    System.out.println("Enter the pattern to match : ");
	    
	    String p = sc.next();
		
		int[] lps = new int[p.length()];
		
		pat(p.toCharArray(), lps);
		
		kmp(s,p,lps);
	}
}

