package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test276
{
	public static void main(String[] args)
	{
		Sample1 t1=new Sample1();
		Sample2 t2=new Sample2();
		t1.start(); //Sample1 class run() can start execution
		t2.start(); //Sample2 class run() can start execution
		System.setProperty("webdriver.chrome.driver","E:\\batch248\\chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
	}
}
