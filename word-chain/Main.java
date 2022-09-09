import java.util.*;

public class Main
{
    static void f(List<String> a, List<String> t,List<String> res, char prev)
    {
        if(a.size() == 0)
            return;
        
        for(String s : a)
        {
            if(s.charAt(0) == prev)
            {
                t.add(s);
                List<String> tl = new ArrayList<>(a);
                tl.remove(s);
                f(tl, t, res, s.charAt(s.length()-1));
                if(t.size() > res.size())
                {
                    res.clear();
                    for(String str : t)
                        res.add(str);
                }
                t.remove(s);
            }
        }
    }
    
    
    static void chain(List<String> a, int n)
    {
        List<String> res = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            List<String> l = new ArrayList<String>(a);
            List<String> t = new ArrayList<>();
            String ts = a.get(i);
            t.add(ts);
            l.remove(ts);
            f(l, t, res, ts.charAt(ts.length()-1));
        }
        
        for(String s : res)
            System.out.print(s + " ");
    }
    
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = 9;
		
		List<String> a = new ArrayList<>(n);
		
		a.add("eat");
		a.add("gno");
		a.add("tbc");
		a.add("cag");
		a.add("ovv");
		a.add("duy");
		a.add("vxz");
		a.add("zpoi");
		a.add("ihgd");
		    
		chain(a, n);
	}
}
