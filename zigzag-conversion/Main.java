import java.util.*;

public class Main
{
    public static String convert(String s, int r) {
        int n = s.length();
        if(r == 1)
            return s;
        
        StringBuilder str = new StringBuilder(n);
        int k = 0;
        
        for(int i=0; i<r; i++)
        {
            int inc = 2 * (r - 1);
            for(int j = i; j < n; j+=inc)
            {
                str.append(s.charAt(j));
                if(i > 0 && i < r-1 && (j + inc - 2 * i < n))
                    str.append(s.charAt(j + inc - 2 * i));
            }
        }
        
        return String.valueOf(str);
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the String to convert : ");
		
		String s = sc.next();
		
		System.out.println("Enter the number of rows : ");
		
		int n = sc.nextInt();
		
		System.out.println("ZigZag Conversion is " + convert(s, n));
	}
}

