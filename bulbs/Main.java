import java.util.*;

public class Main
{
    
    static boolean isSqr(int n)
    {
        int sqrt = (int)Math.sqrt(n);
        
        return sqrt*sqrt == n;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int bublesOn = (int)Math.floor(Math.sqrt(n));
		
		System.out.println("Number of bulbs switched on : " + bublesOn);
		
		System.out.println("Switched on bulbs : ");
		
		for(int i=1; i<=n; i++)
		{
		    if(isSqr(i))
		        System.out.print(i + " ");
		}
		
		
		
	}
}
