import java.util.*;

public class Main
{
    
    static void f(char[][] grid, int i, int j, int r, int c)
    {
        if(i<0 || i>= r || j<0 || j>=c )
            return;
        if(grid[i][j] != '1')
            return;
        
        grid[i][j] = '2';
        
        f(grid, i+1, j, r, c);
        f(grid, i-1, j, r, c);
        f(grid, i, j+1, r, c);
        f(grid, i, j-1, r, c);
    }
    
    static int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int res = 0;
        
        for(int i = 0; i<r; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(grid[i][j] == '1')
                {
                    f(grid, i, j, r, c);
                    res++;
                }
            }
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter row and column space seperated");
		
		int n = sc.nextInt();
		
		int m = sc.nextInt();
		
		char[][] a = new char[n][m];
		
		System.out.println("Enter array elements : ");
		
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		        a[i][j] = sc.next().charAt(0);
		}
		
		System.out.println("Number of islands is : " + numIslands(a));
	}
}
