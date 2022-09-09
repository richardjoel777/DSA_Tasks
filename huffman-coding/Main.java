import java.util.*;



class Node{
    char ch;
    int f;
    Node left;
    Node right;
    
    @Override
    public String toString(){
        return ch + " - " + f;
    }
}

class Comp implements Comparator<Node> {
    public int compare(Node x, Node y)
    {
 
        return x.f - y.f;
    }
}

public class Main
{
    static void print(Node root, String s)
    {
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + ":" + s);
            return;
        }
        
        print(root.left, s + "0");
        print(root.right, s + "1");
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of characters");
		
		int n = sc.nextInt();
		
		char[] a = new char[n];
		
		HashMap<Character,Integer> hs = new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
		    char t = sc.next().charAt(0);
		    hs.put(t, hs.getOrDefault(t, 0) + 1);
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>(hs.size(), new Comp());
		
		for(Character c : hs.keySet())
		{
		    Node hn = new Node();
		    hn.ch = c;
		    hn.f = hs.get(c);
		    hn.left = null;
		    hn.right = null;
		    
		    q.add(hn);
		}
		
		Node root = null;
		
		while(q.size()>1)
		{
		    Node t1 = q.peek();
		    q.poll();
		    
		    Node t2 = q.peek();
		    q.poll();
		    
		    Node hn = new Node();
		    
		    hn.f = t1.f + t2.f;
		    
		    hn.ch = '-';
		    
		    hn.left = t1;
		    hn.right = t2;
		    
		    root = hn;
		    
		    q.add(hn);
		}
		
		print(root, "");
	}
}
