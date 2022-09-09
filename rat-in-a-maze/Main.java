import java.util.*;

public class Main {
    
    static void f(int[][] a, int n, int i, int j, ArrayList<String> res, StringBuilder s)
    {
        if(i == n-1 && j==n-1)
        {
            res.add(s.toString());
            return;
        }
        if(i<0 || j<0 || i>=n || j>=n || a[i][j] == 0)
            return;
        s.append("U");
        a[i][j] = 0;
        f(a, n, i-1, j, res, s);
        a[i][j] = 1;
        s.setLength(s.length() - 1);
        s.append("D");
        a[i][j] = 0;
        f(a, n, i+1, j, res, s);
        a[i][j] = 1;
        s.setLength(s.length() - 1);
        s.append("L");
        a[i][j] = 0;
        f(a, n, i, j-1, res, s);
        a[i][j] = 1;
        s.setLength(s.length() - 1);
        s.append("R");
        a[i][j] = 0;
        f(a, n, i, j+1, res, s);
        a[i][j] = 1;
        s.setLength(s.length() - 1);
    }
    
    public static ArrayList < String > findSum(int[][] arr, int n) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        
        f(arr, n, 0, 0, res, s);
        
        Collections.sort(res);
        
        return res;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array size : ");
		
		int n = sc.nextInt();
		
		int[][] a = new int[n][n];
		
		System.out.println("Enter array elements space seperated");
		
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<n;j++)
		        a[i][j] = sc.nextInt();
		}
		
		System.out.println("Result is : ");
		
		ArrayList<String> res = findSum(a, n);
		
		for(String s : res){
		    System.out.print(s + " ");
		}
    }
}
