import java.util.*;

public class Main
{
    static void spiral(int[][] a)
    {
        int top = 0, down = a.length-1, left = 0, right = a[0].length - 1;
        int dir = 0;
        while(top <= down && left <= right)
        {
            if(dir == 0)
            {
                for(int i=left;i<=right;i++)
                    System.out.print(a[top][i] + " ");
                top++;
            }
            else if(dir == 1)
            {
                for(int i=top; i<=down; i++)
                    System.out.print(a[i][right] + " ");
                right--;
            }
            
            else if(dir == 2)
            {
                for(int i=right;i>=left;i--)
                    System.out.print(a[down][i] + " ");
                down--;
            }
            else
            {
                for(int i=down;i>=top;i--)
                    System.out.print(a[i][left] + " ");
                left++;
            }
            
            dir = (dir + 1) % 4;
        }
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array row and column size ");
		
		int m = sc.nextInt();
		
		int n = sc.nextInt();
		
		int[][] a = new int[m][n];
		
		System.out.println("Enter array elements space seperated");
		
		for(int i=0;i<m;i++)
		{
		    for(int j=0;j<n;j++)
		        a[i][j] = sc.nextInt();
		}
		
		spiral(a);
	}
}
