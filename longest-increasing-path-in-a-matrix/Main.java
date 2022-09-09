import java.util.*;

public class Main
{
    static ArrayList<Integer> ans = new ArrayList<Integer>();
    
    static void f(int[][] a, boolean[][] v, int r, int c, int i, int j, int prev,ArrayList<Integer> t)
    {
        if(i<0 || j<0 || i>=r || j>=c || v[i][j] || prev >= a[i][j])
        {
            if(t.size() > ans.size())
            {
                ans.clear();
                for(int e : t)
                    ans.add(e);
            }
            
            return;
        }
        
        v[i][j] = true;
        t.add(a[i][j]);
        
        f(a, v, r, c, i-1, j, a[i][j], t);
        f(a, v, r, c, i+1, j, a[i][j], t);
        f(a, v, r, c, i, j-1, a[i][j], t);
        f(a, v, r, c, i, j+1, a[i][j], t);
        
        v[i][j] = false;
        t.remove(t.size() - 1);
    }
    
    static void longestIncreasingPath(int[][] a) {
        int r = a.length;
        int c = a[0].length;
        boolean[][] v = new boolean[r][c];

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                f(a, v, r, c, i, j, a[i][j]-1, new ArrayList<Integer>());
            }
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
		
		longestIncreasingPath(a);
		
		System.out.println("Result : ");
		
		for(int i : ans)
		    System.out.print(i + " ");
   
	}
}
