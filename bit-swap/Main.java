import java.util.*;

public class Main
{
    static int swap(int n)
    {
        int res = 0;
        int i = 0;
        
        while(n > 0)
        {
            int t1 = n&1;
            int t2 = (n>>1)&1;
            
            if(t2 == 1)
                res += 1<<i;
            
            i++;
            
            if(t1 == 1)
                res += 1<<i;
            i++;
            n = n>>2;
        }
            
        return res;
    }
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int n = sc.nextInt();
		
		System.out.println("Binary swap value of the given number : " + swap(n));
		
	}
}
