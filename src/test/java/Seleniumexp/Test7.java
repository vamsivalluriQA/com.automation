package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test7
{
	public static void main(String[] args) throws Exception 
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.sentia.in");
		Thread.sleep(5000);
		//get title of page
		String t=driver.getTitle();
		System.out.println(t);
		//Checking for secured
		String u=driver.getCurrentUrl();
		if(u.startsWith("https"))
		{
			System.out.println("Secured site");
		}
		else
		{
			System.out.println("unsecured site");
		}
	}
}









