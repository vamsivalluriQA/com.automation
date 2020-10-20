package Seleniumexp;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test46
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//delete all existing cookies(no need)
		//by default, browser opens without any history & cookies for SWD code
		driver.manage().deleteAllCookies();
		//Launch site
		driver.get("http://www.yahooail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Collect all cookies, which are loaded along with home page
		Set<Cookie> s=driver.manage().getCookies();
		ArrayList<Cookie> l=new ArrayList<Cookie>(s);
		System.out.println("Count of all cookies is "+l.size());
		System.out.println("Cookies are:");
		for(Cookie c:l)
		{
			System.out.println(c.getName()+"---->"+c.getValue()+"--->"+c.getDomain());
		}
		//Close site
		driver.close();
	}
}




