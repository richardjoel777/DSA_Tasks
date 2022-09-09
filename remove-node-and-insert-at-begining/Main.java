import java.util.*;

    
class LinkedList{
    
    Node head;
        
    class Node{
    int val;
    Node next;
    
    Node(int val){
        this.val = val;
    }
    
    
}
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
    
    public void removeAndInsertAtFirst(int num)
    {
        Node p = head, prev = head;
        
        while(p!=null && p.val != num)
        {
            prev = p;
            p = p.next;
        }
        
        if(p == null)
        {
            System.out.println("Value is not present in the list");
            return;
        }
        
        prev.next = p.next;
        
        p.next = head;
        head = p;
        
        print();
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
    
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    
		LinkedList l = new LinkedList();
		
		
		System.out.println("Enter elements of the linked List. press -1 to stop");
		while(true)
		{
		    int num = sc.nextInt();
		    
		    if(num == -1)
		        break;
		    l.insert(num);
		}
		
		System.out.println("Enter the value to remove and push it in the head");
		
		int num = sc.nextInt();
		
		l.removeAndInsertAtFirst(num);
		
	}
}




