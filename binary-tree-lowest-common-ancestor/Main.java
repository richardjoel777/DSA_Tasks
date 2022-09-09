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
    
    private Node leastCommonAncestor(Node root, int a, int b)
    {
        if(root == null)
            return null;
        if(root.val > a && root.val > b)
            return leastCommonAncestor(root.left, a, b);
        if(root.val < a && root.val < b)
            return leastCommonAncestor(root.right, a, b);
        return root; 
    }
    
    public int leastCommonAncestor(int a, int b)
    {
        Node res = leastCommonAncestor(root, a, b);
        return res != null ? res.val : -1;
    }
}



public class Main
{
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
		Tree tree = new Tree();
		
		while(true)
		{
		    System.out.println("Enter your choice\n 1.Insert\n 2.Least Common Ancestor \n 3. Exit");
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
		            System.out.println("Enter Values to find LCA (space seperated)");
		            int res = tree.leastCommonAncestor(sc.nextInt(), sc.nextInt());
		            if(res == -1)
		                System.out.println("Nodes Not Found");
		            else
		                System.out.println("Least Common Ancestor is " + res);
		            break;
		        case 3:
		            return;
		        default:
		            System.out.println("Invalid Choice");
		    }
		}
		
	}
}

