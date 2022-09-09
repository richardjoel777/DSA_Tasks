import java.util.*;

public class Main
{
    static void f(int[] a, int i, List<Integer> temp, List<List<Integer>> res){
        if(i == a.length)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(a[i]);
        f(a, i+1, temp, res);
        temp.remove(temp.size()-1);
        f(a, i+1, temp, res);
    }
    
    static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        f(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of the array");
		
		int n = sc.nextInt();

		
		int[] a = new int[n];
		
		System.out.println("Enter array elements : ");
		
		for(int i=0;i<n;i++)
		{
		        a[i] = sc.nextInt();
		}
		
		List<List<Integer>> res = subsets(a);
		
		System.out.println("subsets : ");
		
		System.out.println(res);
		
	}
}
