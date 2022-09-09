import java.util.*;

public class Main
{
    static boolean f(char[][] b, boolean[][] visited, String w, int ind, int r, int c, int i, int j)
    {
        if(ind == w.length())
            return true;
        if(i >= r || i < 0 || j >= c || j < 0)
            return false;
        if(b[i][j] != w.charAt(ind))
            return false;
        if(visited[i][j])
            return false;
            
        visited[i][j] = true;
        
        b[i][j] = ' ';
        
        boolean up = f(b, visited, w, ind+1, r, c, i-1, j);
        boolean down = f(b, visited, w, ind+1, r, c, i+1, j);
        boolean left = f(b, visited, w, ind+1, r, c, i, j-1);
        boolean right = f(b, visited, w, ind+1, r, c, i, j+1);
        
        visited[i][j] = false;
        
        boolean isFound = up || down || left || right;
        
        if(!isFound)
            b[i][j] = w.charAt(ind);
        
        return isFound;
    }
    
    static boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        
        boolean[][] visited = new boolean[r][c];
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                boolean res = f(board, visited, word, 0, r, c, i, j);
                if(res)
                    return true;
            }
        }
        
        return false;
    }
    
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    
		System.out.println("Enter the number of rows and columns space seperated");
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		char[][] board = new char[r][c];
		
		System.out.println("Enter the board characters spce seperated");
		
		for(int i=0;i<r;i++)
		{
		    for(int j=0;j<c;j++)
		    {
		        board[i][j] = sc.next().charAt(0);
		    }
		}
		
		System.out.println("Enter the word to search");
		
		String word = sc.next();
		
		System.out.println("Given Word is " + (exist(board, word) ? "Found" : "Not Found"));
		
		for(int i=0;i<r;i++)
		{
		    for(int j=0;j<c;j++)
		    {
		        System.out.print(board[i][j] + " ");
		    }
		    
		    System.out.println();
		}
	}
}
