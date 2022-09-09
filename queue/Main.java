import java.util.*;

class Queue
{
    Node front,rear;
    
    class Node{
        int val;
        Node next;
        
        Node(int val)
        {
            this.val = val;
        }
    }
    
    public void enqueue(int val)
    {
        Node newNode = new Node(val);
        
        if(rear == null)
        {
            front = rear = newNode;
            return;
        }
        
        rear.next = newNode;
        rear = newNode;
    }
    
    public void dequeue()
    {
        if(front == null)
        {
            System.out.println("Queue is Empty");
            return;
        }
        
        int val = front.val;
        
        front = front.next;
        
        if(front == null)
            rear = null;
        
        System.out.println(val + " is removed");
    }
    
    public void print()
    {
        if(front == null)
        {
            System.out.println("Queue is Empty");
            return;
        }
        Node t = front;
        while(t != null)
        {
            System.out.print(t.val + " ");
            t = t.next;
        }
        System.out.println();
    }
    
    public void peek()
    {
        if(front == null)
            System.out.println("Queue is Empty");
        else
            System.out.println(front.val);
    }
}


public class Main
{
	public static void main(String[] args) {
		Queue q = new Queue();
		Scanner sc = new Scanner(System.in);
		int ch;
		while(true){
		    System.out.println("Enter Your Choice: 1. Enqueue 2. Dequeue 3. Peek 4. Print 5. Exit\n");
		    ch = sc.nextInt();
		    switch(ch)
		    {
		        case 1:
		            System.out.println("Enter value to enqueue");
		            q.enqueue(sc.nextInt());
		            break;
		        case 2:
		            q.dequeue();
		            break;
		        case 3:
		            q.peek();
		            break;
		        case 4:
		            q.print();
		            break;
		        case 5:
		            return;
		    }
		    
		}
	}
}
