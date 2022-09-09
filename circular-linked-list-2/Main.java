import java.util.*;

class CircularLinkedList{
    Node head;
    
    class Node{
        int val;
        Node next;
        
        Node(int val){
            this.val = val;
        }
    }
    
    public void insertAtEnd(int val)
    {
        Node newNode = new Node(val);
        if(head == null)
        {
            head = newNode;
            newNode.next = head;
            return;
        }
        
        Node t = head;
        
        while(t.next != head)
        {
            t = t.next;
        }
        t.next = newNode;
        newNode.next = head;
        
    }
    
    public void deleteAtEnd()
    {
        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }
        Node prev = null;
        Node t = head;
        
        if(t.next == head)
        {
            head = null;
            System.out.println(t.val + " is removed");
            return;
        }
        
        while(t.next != head)
        {
            prev = t;
            t = t.next;
        }
        
        System.out.println(t.val + " is removed");
        
        prev.next = head;
    }
    
    public void print()
    {
        if(head == null)
        {
            System.out.println("List is Empty");
            return;
        }
        
        Node t = head;
        do{
            System.out.print(t.val + " ");
            t = t.next;
        }while(t != head);
        
        System.out.println();
    }
}

public class Main
{
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		Scanner sc = new Scanner(System.in);
		int ch;
		do{
		    System.out.println("Enter Your Choice: 1. Insert at end 2. Delete at end 3. Print 4. Exit\n");
		    ch = sc.nextInt();
		    switch(ch)
		    {
		        case 1:
		            System.out.println("Enter value to Insert");
		            list.insertAtEnd(sc.nextInt());
		            break;
		        case 2:
		            list.deleteAtEnd();
		            break;
		        case 3:
		            list.print();
		            break;
		        case 4:
		            return;
		    }
		    
		}while(ch >= 0);

    
	}
}

