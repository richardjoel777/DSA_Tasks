import java.util.*;

public class Main
{
    static int gray(int n)
    {
        int res = 0;
        int i = 0;
        
        while(n > 0)
        {
            int t1 = n&1;
            int t2 = (n>>1)&1;
            
            if(t1 + t2 == 1)
                res += 1<<i;
            
            n = n>>1;
            i++;
        }
            
        return res;
    }
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int n = sc.nextInt();
		
		System.out.println("Gray Code value of the given number : " + gray(n));
		
	}
}

