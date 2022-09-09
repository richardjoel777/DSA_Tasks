import java.util.*;

public class Main
{
    static void f(char[][] a, int i, int j, int r, int c)
    {
        if(a[i][j] != 'O')
            return;
        
        a[i][j] = '1';
        
        if(i>1) f(a, i-1, j, r, c);
        if(i+1 < r) f(a, i+1, j, r, c);
        if(j>1) f(a, i, j-1, r, c);
        if(j+1 < c) f(a, i, j+1, r, c);
    }
    
    static void convert(char[][] a, int r, int c)
    {
        boolean[][] visited = new boolean[r][c];
        
        for(int i=0;i<r;i++)
        {
            f(a, i, 0, r, c);
            f(a, i, c-1, r, c);
        }
        
        for(int i=0;i<c;i++)
        {
            f(a, 0, i, r, c);
            f(a, r-1, i, r, c);
        }
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(a[i][j] == 'O')
                    a[i][j] = 'X';
                else if(a[i][j] == '1')
                    a[i][j] = 'O';
            }
        }
    }
    
    static void solve(char[][] a) {
        
        
        int r = a.length;
        int c = a[0].length;
        
        convert(a, r, c);
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the row and column size of array : ");
		int r = sc.nextInt();
		
		int c = sc.nextInt();
		
		char[][] a = new char[r][c];
		
		System.out.println("Enter Array elements of x and o");
		
		for(int i=0;i<r;i++)
		{
		    for(int j=0;j<c;j++)
		    {
		        a[i][j] = sc.next().charAt(0);
		    }
		}
		
		solve(a);
		
		System.out.println("Resultant array is : ");
		
		for(int i=0;i<r;i++)
		{		    for(int j=0;j<c;j++)
		    {
		        System.out.print(a[i][j] + " ");
		    }
		    
		    System.out.println();
		}
		
	}
}
