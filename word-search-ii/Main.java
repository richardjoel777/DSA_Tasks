import java.util.*;

public class Main
{
    static boolean f(char[][] b, String w, int ind, int r, int c, int i, int j)
    {
        if(ind == w.length())
            return true;
        if(i >= r || i < 0 || j >= c || j < 0)
            return false;
        if(b[i][j] != w.charAt(ind))
            return false;
            
            
        b[i][j] = ' ';
        
        boolean up = f(b, w, ind+1, r, c, i-1, j);
        boolean down = f(b, w, ind+1, r, c, i+1, j);
        boolean left = f(b, w, ind+1, r, c, i, j-1);
        boolean right = f(b, w, ind+1, r, c, i, j+1);
        
        boolean isFound = up || down || left || right;
        
        b[i][j] = w.charAt(ind);
        
        return isFound;
    }
    
    static boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                boolean res = f(board, word, 0, r, c, i, j);
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
		
		System.out.println("Enter the number of words to search");
		
		int n = sc.nextInt();
		
		String[] words = new String[n];
		
		System.out.println("Enter the words to search");
		
		for(int i=0;i<n;i++)
		    words[i] = sc.next();
		    
		Set<String> st = new HashSet<>();
		
		for(String w : words)
		{
		    if(exist(board, w))
		        st.add(w);
		}
		
		System.out.println("Found words are : ");
		
		for(String s : st)
		    System.out.println(s);
	}
}

