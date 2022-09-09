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
    
    public String palindrome()
    {
        Node fast = head, slow = head;
        Stack<Integer> st = new Stack<>();
        
        while(fast != null && fast.next != null)
        {
            st.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null)
            slow = slow.next;
            
        while(slow != null)
        {
            if(slow.val != st.pop())
                return "not a palindrome";
            slow = slow.next;
        }
        
        return "a palindrome";
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
		
		System.out.println("Given Linked List is " + l.palindrome());

		
		
	}
}


