import java.util.*;

public class Main
{
    static int comp(int n)
    {
        int res = 0;
        int i = 0;
        
        while(n > 0)
        {
            if((n & 1) == 0)
                res += 1<<i;
            
            i++;
            n = n>>1;
        }
        
        return res;
    }
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int n = sc.nextInt();
		
		System.out.println("Complement the given number : " + comp(n));
		
	}
}

