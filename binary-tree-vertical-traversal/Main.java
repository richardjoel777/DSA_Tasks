import java.util.*;

class Tree {

    Node root;
    
    class Node{
        int val;
        Node right;
        Node left;
        
        Node(int val)
        {
            this.val = val;
        }
    }
    
    class Tuple{
        Node node;
        int hd;
        
        Tuple(Node node,int hd)
        {
            this.node = node;
            this.hd = hd;
        }
        
    }
    
    private void verticalTraversal(Node root) {
        
        TreeMap<Integer,List<Integer>> hs = new TreeMap<>();
        
        Queue<Tuple> q =new LinkedList<Tuple>();
        
        q.add(new Tuple(root, 0));
        
        while(!q.isEmpty())
        {
            
            int size = q.size();
            
            for(int i=0; i<size; i++)
            {
            
            Tuple t = q.remove();
            
            if(!hs.containsKey(t.hd))
            {
                List<Integer> l = new ArrayList<>();
                hs.put(t.hd, l);
            }
            
            hs.get(t.hd).add(t.node.val);
            
            if(t.node.left != null)
                q.add(new Tuple(t.node.left, t.hd - 1));
            
            if(t.node.right != null)
                q.add(new Tuple(t.node.right, t.hd + 1));
            }
        }
        
        for(Map.Entry<Integer, List<Integer>> entry : hs.entrySet())
        {
            for(int i : entry.getValue())
                System.out.print(i + " ");
            System.out.println();
        }
    }
    
    public void verticalTraversal()
    {
        verticalTraversal(root);
    }
    
    public void insert(int val)
    {
        Node new_node = new Node(val);
        if (root == null) {
            root = new_node;
            return;
        }
        Node current = root;
        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new_node;
                    break;
                } else
                    current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new_node;
                    break;
                } else
                    current = current.right;
            }
        }
    }
    
    
}



public class Main
{
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
		Tree tree = new Tree();
		
		while(true)
		{
		    System.out.println("Enter your choice\n 1.Insert\n 2. Vertical Order Traversal\n 3. Exit");
		    int ch = sc.nextInt();
		    switch(ch)
		    {
		        case 1:
		        {
		            System.out.println("Enter the items to Insert. enter -1 to stop");
		            while(true)
		            {
		                int num = sc.nextInt();
		                if(num == -1)
		                    break;
		                tree.insert(num);
		            }
		            break;
		        }
		        case 2:
		            tree.verticalTraversal();
		            break;
		        case 3:
		            return;
		        default:
		            System.out.println("Invalid Choice");
		    }
		}
		
	}
}