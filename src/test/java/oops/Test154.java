package oops;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test154 
{
	public static void main(String[] args)
	{
		//Open browser by creating driver object
		System.setProperty("webdriver.chrome.driver","E:\\batch248\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//create object to Sample4
		Sample4 obj=new Sample4(driver);
		obj.launch("http://www.google.co.in");
		String t=obj.title();
		System.out.println(t);
		obj.closeSite();
	}
}





