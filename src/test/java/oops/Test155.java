package oops;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Test155
{
	public static void main(String[] args)
	{
		//Open browser by creating driver object
		System.setProperty("webdriver.gecko.driver","E:\\batch248\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		//create object to Sample4
		Sample4 obj=new Sample4(driver);
		obj.launch("http://www.gmail.com");
		String t=obj.title();
		System.out.println(t);
		obj.closeSite();
	}
}





