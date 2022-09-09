import java.util.*;

public class Main
{
    
    static int prime = 101;
    
    static int rka(char[] s, char[] p)
    {
        int m = p.length;
        int n = s.length;
        
        int patternHash = createHash(p, m-1);
        
        int stringHash = createHash(s, m-1);
        
        for(int i=1; i<=n-m+1; i++)
        {
            if(patternHash == stringHash && isEquals(s, i-1, i+m-1, p, 0, m))
            {
                return i-1;
            }
            if(i<n-m+1){
                stringHash = alterHash(s, i-1, i+m-1, stringHash, m);
            }
        }
        
        return -1;
    }
    
    static int alterHash(char[] s, int oldIndex, int newIndex, int oldHash, int m)
    {
        int newHash = oldHash - s[oldIndex];
        newHash = newHash / prime;
        newHash += s[newIndex]*Math.pow(prime, m-1);
        
        return newHash;
    }
    
    static int createHash(char[] s, int end)
    {
        int hash = 0;
        for(int i=0;i<=end;i++)
        {
            hash += s[i] * Math.pow(prime, i); 
        }
        
        return hash;
    }
    
    
    static boolean isEquals(char[] s1, int start1, int end1, char[] s2, int start2, int end2)
    {
        if(end1 - start1 != end2 - start2)
            return false;
            
        for(int i=start1, j=start2; i<end1 && j<end2; i++, j++)
        {
            if(s1[i] != s2[j])
                return false;
        }
        
        return true;
    }
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter the string : ");
	    
	    String s = sc.next();
	    
	    System.out.println("Enter the pattern to match : ");
	    
	    String p = sc.next();
	    
	    int res = rka(s.toCharArray(), p.toCharArray());
	    
	    System.out.println("Pattern found at : " + res);
	}
}

