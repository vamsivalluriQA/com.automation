package Seleniumexp;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Test5
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.edge.driver","E:\\batch247\\msedgedriver.exe");
		//SWD
		EdgeOptions eo=new EdgeOptions();
		//eo.setBinary("C:\\Program Files (x86)\\microsoft\\Edge Beta\\Application\\msedge.exe");
		EdgeDriver obj=new EdgeDriver(eo);
		obj.get("http://www.yahoomail.com");

	}

}









