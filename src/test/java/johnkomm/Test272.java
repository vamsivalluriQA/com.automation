package johnkomm;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Test272
{
	public static void main(String[] args)
	{
		//Get date and time
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Calendar cal=Calendar.getInstance();
		String x=sf.format(cal.getTime());
		System.out.println(x);
	}
}








