import java.util.*;


class Graph
{
    List<LinkedList> edges;
    
    
    class LinkedList{
        Node head;
        
        class Node{
            int val;
            Node next;
            
            Node(int val)
            {
                this.val = val;
            }
        }
        
        public void add(int val)
        {
            Node newNode = new Node(val);
            
            if(head == null)
            {
                head = newNode;
                return;
            }
            
            Node t = head;
            while(t.next != null)
                t = t.next;
            t.next = newNode;
        }
        
        public void print()
        {
            Node t = head;
            
            while(t != null)
            {
                System.out.print(t.val + " ");
                t = t.next;
            }
            
            System.out.println();
        }
        
        public boolean contains(int val)
        {
            Node t = head;
            while(t != null)
            {
                if(t.val == val)
                    return true;
                t = t.next;
            }
            
            return false;
        }
        
        public void remove(int val)
        {
            Node t = head;
            
            if(head == null)
                return;
                
            Node prev = head;
            
            while(t!=null && t.val != val)
            {
                prev = t;
                t = t.next;
            }
            
            prev.next = prev.next.next;
        }
    }
    
    int v;
    
    Graph(int v)
    {
        edges = new ArrayList<>(v);
        for(int i=0; i<v; i++)
            addVertex();
    }
    
    public void addVertex()
    {
       LinkedList t = new LinkedList();
       
       edges.add(t);
       
       v = v + 1;
    }
    
    public void addEdge(int s, int d)
    {
        if(s >= v || d >= v)
        {
            System.out.println("Enter Valid Source/Destination vertex");
            return;
        }
        
        if(!edges.get(s).contains(d))
            edges.get(s).add(d);
        if(!edges.get(d).contains(s))
            edges.get(d).add(s);
    }
    
    public void deleteEdge(int s, int d)
    {
        if(s >= v || d >= v)
        {
            System.out.println("Enter Valid Source/Destination vertex");
            return;
        }
        
        if(edges.get(s).contains(d))
            edges.get(s).remove(d);
    }
    
        public void print()
        {
            for(int i=0;i<v;i++)
            {
                LinkedList t = edges.get(i);
                System.out.print(i + " --> ");
                t.print();
            }
        }
}


public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter Initial Number of Vertices : ");
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

