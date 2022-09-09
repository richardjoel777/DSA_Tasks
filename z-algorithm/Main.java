import java.util.*;
class Main{
    static void createZarray(String str, int Z[]){
       int n = str.length();
       int L, R,k;
       L = R = 0;
       for (int i = 1; i < n; ++i){
          if (i > R){
             L = R = i;
             while (R<n && str.charAt(R-L)== str.charAt(R))
             {
                R++;
             }
            Z[i] = R-L;
            R--;
          }
          else {
             k = 0;
            if (Z[k] < R-i+1)
                Z[i] = 0;
            else
             {
                L = R = i;
                while (R<n && str.charAt(R-L)== str.charAt(R))
                {
                    R++;
                }
                Z[i] = R-L;
                R--;
             }
          }
       }
    }
    static void zAlgorithm(String text, String pattern){
       String str = pattern+"$"+text;
       int len = str.length();
       int Z[]=new int[len];
       createZarray(str, Z);
       for (int i = 0; i < len; ++i){
          if (Z[i] == pattern.length())
             System.out.println((i-pattern.length()-1));
       }
    }
    public static void main(String args[])
    {
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Enter the String : ");
       String str = sc.next();
       
       System.out.println("Enter the pattern : ");
       String pattern = sc.next();
       
       System.out.println("Pattern found at : ");
       zAlgorithm(str, pattern);
    }
}