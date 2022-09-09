import java.util.*;

public class Main
{
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack < Integer > st = new Stack < > ();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }
        
        while (!st.isEmpty())
            st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }
    
    public static int maximalRectangle(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n;j++)
            {
                if(i > 0 && a[i][j] == 1)
                    a[i][j] += a[i-1][j];
            }
        }
        
        int maxi = 0;
        
        for(int[] r : a)
        {
            maxi = Math.max(maxi, largestRectangleArea(r));
        }
        
        return maxi;
    }
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter row and column space seperated");
		
		int n = sc.nextInt();
		
		int m = sc.nextInt();
		
		int[][] a = new int[n][m];
		
		System.out.println("Enter binary 1's and 0's for each row space seperated");
		
		for(int i=0;i<n;i++)
		{
		    for(int j=0;j<m;j++)
		        a[i][j] = sc.nextInt();
		}
		
		System.out.println("Maximum Rectangle Area is : " + maximalRectangle(a));
	}
}

