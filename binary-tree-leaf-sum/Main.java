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
    
    private boolean isLeaf(Node node)
    {
        return (node.left == null && node.right == null);
    }
    
    private int leafSum(Node node)
    {
        if(node == null)
            return 0;
        
        if(isLeaf(node))
            return node.val;
            
            
        int leftSum = leafSum(node.left);
        int rightSum = leafSum(node.right);
        
        return (leftSum + rightSum);
    }
    
    public int leafSum()
    {
        return leafSum(root);
    }
}



public class Main
{
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
		Tree tree = new Tree();
		
		while(true)
		{
		    System.out.println("Enter your choice\n 1.Insert\n 2.Leaf Sum \n 3. Exit");
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
		            System.out.println("Leaf Sum of the Tree is " + tree.leafSum());
		            break;
		        case 3:
		            return;
		        default:
		            System.out.println("Invalid Choice");
		    }
		}
		
	}
}



