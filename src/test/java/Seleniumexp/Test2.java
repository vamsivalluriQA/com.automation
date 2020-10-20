package Seleniumexp;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","E:\\batch247\\geckodriver.exe");
		//SWD
		FirefoxDriver obj=new FirefoxDriver();
		obj.get("http://www.facebook.com");
		obj.close();

	}

}
