package johnkomm;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test279 
{
	public static void main(String[] args)
	{
		String x="dkbvksgn56 sdklhgerhg345 fkgjjhg 78 riljhgerg3rght 3sjkfgw";
		Pattern p=Pattern.compile("[0-9]+");
		Matcher m=p.matcher(x);
		//copy matched values into an array
		ArrayList<String> y=new ArrayList<String>();
		while(m.find())
		{
			System.out.println(m.group());
			y.add(m.group());
		}
	}
}



