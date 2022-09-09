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
    
    private void preOrder(Node node)
    {
        if(node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    
    public void preOrder()
    {
        preOrder(root);
        System.out.println();
    }
    
    private void inOrder(Node node)
    {
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }
    
    public void inOrder()
    {
        inOrder(root);
        System.out.println();
    }
    
    private void postOrder(Node node)
    {
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
    
    public void postOrder()
    {
        postOrder(root);
        System.out.println();
    }
    
    public void levelOrderTraversal()
    {
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i=0; i<size; i++)
            {
                Node t = q.remove();
                System.out.print(t.val + " ");
                
                if(t.left != null)
                    q.add(t.left);
                if(t.right != null)
                    q.add(t.right);
            }
            
            System.out.println();
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
		    System.out.println("Enter your choice\n 1.Insert\n 2.Inorder\n 3.Preorder\n 4.Postorder\n 5.Level Order Traversal\n 6. Exit");
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
		            tree.inOrder();
		            break;
		        case 3:
		            tree.preOrder();
		            break;
		        case 4:
		            tree.postOrder();
		            break;
		        case 5:
		            tree.levelOrderTraversal();
		            break;
		        case 6:
		            return;
		        default:
		            System.out.println("Invalid Choice");
		    }
		}
		
	}
}

