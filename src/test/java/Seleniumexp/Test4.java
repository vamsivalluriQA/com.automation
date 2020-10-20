package Seleniumexp;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test4
{
	public static void main(String[] args)
	{
		//Set IE browser zoom level to 100%
		System.setProperty("webdriver.ie.driver","E:\\batch247\\iedriverserver.exe");
		//SWD
		InternetExplorerDriver obj=new InternetExplorerDriver();
		obj.get("http://www.amazon.in");
		

	}

}
