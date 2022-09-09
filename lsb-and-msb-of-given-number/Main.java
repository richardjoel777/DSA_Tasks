import java.util.*;

public class Main
{
    
    static int lsb(int n)
    {
        return n&1;
    }
    
    static int msb(int n)
    {
        int res = 1;
        
        while(n>0)
        {
            n = n>>1;
            res = res<<1;
        }
        
        return res>>1;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int n = sc.nextInt();
		
		System.out.println("LSB of the given number : " + lsb(n));
		
		System.out.println("MSB of the given number : " + msb(n));
		
	}
}
