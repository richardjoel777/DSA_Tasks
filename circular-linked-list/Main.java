import java.util.*;

class CircularLinkedList{
    Node head;
    
    int size = 0;
    
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
            size++;
            return;
        }
        
        Node t = head;
        
        while(t.next != head)
        {
            t = t.next;
        }
        t.next = newNode;
        newNode.next = head;
        size++;
        
    }
    
    public void insertAtBegining(int val)
    {
        Node newNode = new Node(val);
        if(head == null)
        {
            head = newNode;
            newNode.next = head;
            size++;
            return;
        }
        
        newNode.next = head;
        Node t = head;
        
        while(t.next != head)
        {
            t = t.next;
        }
        t.next = newNode;
        head = newNode;
        size++;
        
    }
    
    public void insertAtPosition(int val, int pos)
    {
        if(pos > size)
        {
            System.out.println("Enter Valid Position\n");
            return;
        }

        if(pos == 1)
        {
            insertAtBegining(val);
            return;
        }
        
        Node newNode = new Node(val);
        Node t = head;
        
        for(int i=1; i<pos-1; i++)
        {
            t = t.next;
        }
        
        Node p = t.next;
        newNode.next = p;
        t.next = newNode;
        
        size++;
    }
    
    public void deleteAtBegining()
    {
        if(head == null)
            return;
        Node t = head.next;
        if(t == head)
        {
            t = null;
            size--;
            return;
        }
        t.next = t;
        head = t;
        size--;
    }
    
    public void deleteAtEnd()
    {
        if(head == null)
            return;
        Node prev = null;
        Node t = head;
        
        if(t.next == head)
        {
            head = null;
            size--;
            return;
        }
        
        while(t.next != head)
        {
            prev = t;
            t = t.next;
        }
        
        prev.next = head;
        size--;
    }
    
    public void deleteAtPosition(int pos)
    {
        if(pos > size)
        {
            System.out.println("Enter Valid Position\n");
            return;
        }
        
        if(pos == 1)
        {
            deleteAtBegining();
            return;
        }
        
        if(pos == size)
        {
            deleteAtEnd();
            return;
        }
        
        Node t = head;
        
        for(int i = 1; i < pos - 1; i++)
        {
            t = t.next;
        }

        t.next = t.next.next;
        size--;
        
    }
    
    public void print()
    {
        if(head == null)
            return;
        
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
		    System.out.println("Enter Your Choice: 1. Insert at begining 2. Insert at End 3. Insert at Position 4. Print 5. Delete at begining 6. Delete at End 7. Delete at Position 8. Exit\n");
		    ch = sc.nextInt();
		    switch(ch)
		    {
		        case 1:
		            System.out.println("Enter value to Insert");
		            list.insertAtBegining(sc.nextInt());
		            break;
		        case 2:
		            System.out.println("Enter value to Insert");
		            list.insertAtEnd(sc.nextInt());
		            break;
		        case 3:
		            System.out.println("Enter value to Insert and Position");
		            list.insertAtPosition(sc.nextInt(), sc.nextInt());
		            break;
		        case 4:
		            list.print();
		            break;
		        case 5:
		            list.deleteAtBegining();
		            break;
		        case 6:
		            list.deleteAtEnd();
		            break;
		        case 7:
		            list.deleteAtPosition(sc.nextInt());
		            break;
		        case 8:
		            return;
		    }
		    
		}while(ch >= 0);

    
	}
}


