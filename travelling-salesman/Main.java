import java.util.*;
class Main {

    static int f(int[][] cost, Set<Integer> v, int i, int n)
    {
        
        if(v.size() == n)
            return cost[i][0];
        
        int mini = Integer.MAX_VALUE;
        
        for(int j=1;j<n;j++)
        {
            if(!v.contains(j))
            {
                v.add(j);
                mini = Math.min(mini, cost[i][j] + f(cost, v, j, n));
                v.remove(j);
            }
        }
        
        return mini;
    }
    
    static int total_cost(int[][] cost)
    {
        int n = cost.length;
        
        Set<Integer> v = new HashSet<>();
        
        v.add(0);
        
        return f(cost, v, 0, n);
        
    }
    
	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
		
		int[][] cost = {{0,1000,5000},{5000,0,1000},{1000,5000,0}};
		
		System.out.println("Minimum cost is " + total_cost(cost));
	}
}
