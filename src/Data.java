import java.util.HashMap;

public class Data
{
	public static HashMap<String,String> getCredentials() 
	{
		HashMap<String,String> loginCredentials = new HashMap<String,String>();
		loginCredentials.put("customer","naveenk_test@123");
		loginCredentials.put("admin","adminuser_test@123");
		return loginCredentials;
	}
	
	public static HashMap<Integer,String> getMonth()
	{
		HashMap<Integer,String> month = new HashMap<Integer,String>();
		month.put(1, "January");
		month.put(2, "Feburary");
		month.put(3, "March");
		month.put(4, "April");
		month.put(5, "May");
		month.put(6, "June");
		month.put(7, "July");
		month.put(8, "August");
		month.put(9, "September");
		month.put(10, "October");
		month.put(11, "November");
		month.put(12, "December");
		return month;
	}
}
