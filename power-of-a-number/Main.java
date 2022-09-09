import java.util.*;

public class Main
{
    static int pow(int x, int n){
        int res = 1;
        while (n > 0)
        {
            int lsb = (n & 1);
            if (lsb == 1)
                res = res * x;
            x = x * x;
            n = n >> 1;
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int x = sc.nextInt();
		System.out.println("Enter the power : ");
		int n = sc.nextInt();
		
		System.out.println("the result is : " + pow(x,n));
	}
}
