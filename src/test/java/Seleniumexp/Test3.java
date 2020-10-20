package Seleniumexp;

import org.openqa.selenium.opera.OperaDriver;

public class Test3 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.opera.driver","E:\\batch247\\operadriver_win64\\operadriver.exe");
		//SWD
		OperaDriver obj=new OperaDriver();
		obj.get("http://www.gmail.com");
	}
}
