import java.util.*;

class Node{
    int val;
    Node next;
    
    Node(int val){
        this.val = val;
    }
}
    
class LinkedList{
    
    Node head;
    
    public void insert(int val)
    {
        Node newNode = new Node(val);
        if(head == null)
        {
            head = newNode;
            return;
        }
        
        Node t = head;
        
        while(t.next != null)
        {
            t = t.next;
        }
        t.next = newNode;
    }
    
    
    public void print()
    {
        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }
        
        Node t = head;
        while(t != null){
            System.out.print(t.val + " ");
            t = t.next;
        };
        
        System.out.println();
    }
}

public class Main
{
    
    public static Node merge(Node h1, Node h2)
    {
        
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;
        
        Node p1 = h1, p2 = h2;
        Node prev1 = h1, prev2 = h2;
        
        while(p1 != null && p2 != null)
        {
            Node t1 = p1.next;
            Node t2 = p2.next;
            
            p1.next = p2;
            p2.next = t1;
            
            prev1 = p1;
            prev2 = p2;
            
            p1 = t1;
            p2 = t2;
        }
        
        if(p2 != null)
        {
            prev2.next = p2;
            prev1.next = prev2;
        }
        
        return h1;
    }
    
    public static void print(Node head)
    {
        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }
        
        Node t = head;
        while(t != null){
            System.out.print(t.val + " ");
            t = t.next;
        };
        
        System.out.println();
    }
    
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		
		
		System.out.println("Enter elements of first linked List. press -1 to stop");
		while(true)
		{
		    int num = sc.nextInt();
		    
		    if(num == -1)
		        break;
		    l1.insert(num);
		}
		
		System.out.println("Enter elements of second linked List. press -1 to stop");
		while(true)
		{
		    int num = sc.nextInt();
		    
		    if(num == -1)
		        break;
		    l2.insert(num);
		}
		
		Node res = merge(l1.head, l2.head);
		
		System.out.println("Merged List is : ");
		
		print(res);
		
		
	}
}

