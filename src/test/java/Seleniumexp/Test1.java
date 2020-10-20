package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test1
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		//SWD
		ChromeDriver obj=new ChromeDriver();
		obj.get("http://www.google.co.in");
		
		
		
	}
}








