import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayToAL 
{
	public static void conversion1()
	{
		String s[] = {"Steve","US","Germany","WashingtonDC","BarrakObama"};
		List<String> l = Arrays.asList(s);
		ArrayList<String> a = new ArrayList<String>(l);
		System.out.println(a);
		System.out.println("-------------------------------------");
	}
	
	public static void conversion2()
	{
		ArrayList a1 = new ArrayList();
		a1.add("xyz");
		a1.add("pqr");
		a1.add("Clinton");
		ArrayList<String> a2 = new ArrayList<String>(a1);
		a2.add("SatyaNadela");
		for(String s:a2)
		{
			System.out.println("The a1 element  : "+s);
		}
		System.out.println("---------------------------------------");
	}
	
	public static void counter()
	{
		ArrayList<String> a1 = new ArrayList<String>(41);
		int counter = 0;
		for(String s:a1)
		{
			counter++;
		}
		System.out.println("Counter : "+counter);
	}
	
	public static void insertAtIndex()
	{
		//ArrayList<StringBuilder> a = new ArrayList<StringBuilder>();
		ArrayList a1 = new ArrayList();
		a1.add("xyz");
		a1.add("pqr");
		a1.add("mno");
		System.out.println(a1);
		a1.add(1,"rst");
		a1.add(4,"abcd");
		System.out.println(a1);
	}
	
	public static void main(String[] args) 
	{
		/*conversion1();
		conversion2();
		counter();*/
		insertAtIndex();
	}
}
