import java.util.*;

class Item{
    int value;
    int weight;
    Item(int v, int w)
    {
        value = v;
        weight = w;
    }
}

class Comp implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b)
    {
        double r1 = (double)a.value / (double)a.weight;
        double r2 = (double)b.value / (double)b.weight;
        if(r1 < r2)
            return 1;
        if(r1 > r2)
            return -1;
        return 0;
    }
}

public class Main
{
    
    
    static double fractionalKnapsack(int t, Item a[], int n) 
    {
        Comp c = new Comp();
        Arrays.sort(a, c);
        
        int curr = 0;
        double res = 0.0;
        
        for(int i=0; i<n; i++)
        {
            if(curr + a[i].weight <= t)
            {
                curr += a[i].weight;
                res += a[i].value;
            }
            else
            {
                int rem = t - curr;
                res += ((double)a[i].value / (double)a[i].weight) * (double)rem;
                break;
            }
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter array size");
		int n = sc.nextInt();
		
		Item[] a = new Item[n];
		
		System.out.println("Enter Values and Weights space seperated : ");
		
		for(int i=0;i<n;i++)
		    a[i] = new Item(sc.nextInt(), sc.nextInt());
		    
		System.out.println("Enter Maximum Weight : ");
		
		int t = sc.nextInt();
		    
	    System.out.println("Maximum value can be obtained is " + fractionalKnapsack(t, a, n));
	}
}
