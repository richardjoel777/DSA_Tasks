import java.util.*;


class Graph
{
    int[][] edges;
    
    int v;
    
    Graph(int v)
    {
        this.v = v; 
        edges = new int[v][v];
    }
    
    public void addVertex()
    {
        int[][] newEdges = new int[v+1][v+1];
        
        for(int i=0; i<v; i++)
            for(int j=0; j<v; j++)
                newEdges[i][j] = edges[i][j];
        v = v + 1;
        edges = newEdges;
    }
    
    public void addEdge(int s, int d)
    {
        if(s >= v || d >= v)
        {
            System.out.println("Enter Valid Source/Destination vertex");
            return;
        }
        
        edges[s][d] = 1;
        
    }
    
    public void deleteEdge(int s, int d)
    {
        if(s >= v || d >= v)
        {
            System.out.println("Enter Valid Source/Destination vertex");
            return;
        }
        
        edges[s][d] = 0;
        
    }
    
    public void print()
    {
        for(int i=0;i<v;i++)
        {
            System.out.print(i + " --> ");
            for(int j=0;j<v;j++)
            {
                if(edges[i][j] == 1)
                {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}


public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter Initial Number of edges : ");
	    int v = sc.nextInt();
	    
	    Graph graph = new Graph(v);
		
		while(true)
		{
		    System.out.println("Enter your choice\n 1.Add Vertex\n 2.Add Edge\n 3.Delete Edge\n 4.Print\n 5.Exit");
		    int ch = sc.nextInt();
		    
		    switch (ch) {
		        case 1:
		            {
		                graph.addVertex();
		                break;
		            }
		        case 2:
		            {
		                System.out.println("Enter the source and Destination space seperated. enter -1 -1 to stop");
		                while(true)
		                {
		                    int s = sc.nextInt();
		                    int d = sc.nextInt();
		                    
		                    if(s == -1 || d == -1)
		                        break;
		                    graph.addEdge(s, d);
		                }
		                break;
		            }
		        case 3:
		            {
	                    System.out.println("Enter the source and Destination space seperated. enter -1 -1 to stop");
		                while(true)
		                {
		                    int s = sc.nextInt();
		                    int d = sc.nextInt();
		                    
		                    if(s == -1 || d == -1)
		                        break;
		                    graph.deleteEdge(s, d);
		                }
		                break;
		            }
		        case 4:
		            {
		                graph.print();
		                break;
		            }
		        case 5:
		            return;
		        default:
		            System.out.println("Wrong Choice Try Again");
		    }
		}
		
		
	}
}
