package Seleniumexp;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test48
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");          
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Delete all existing cookies(Optional, by default browser opens without any history)
		driver.manage().deleteAllCookies();
		//Goto target page
		driver.get("http://www.ebay.com");
		Thread.sleep(5000); 
		//Add cookie
        Cookie nc=new Cookie("mycookie","magnitia"); //new cookie with name and value
        driver.manage().addCookie(nc);
		//Collect all cookies related to that page
		Set<Cookie> cl=driver.manage().getCookies();
		ArrayList<Cookie> l=new ArrayList<Cookie>(cl);
		System.out.println("Count of Cookies is "+l.size());
		for(Cookie c:l)
		{
			if(c.isHttpOnly())
			{
				System.out.println(c.getName()+" is Http-only cookie");                              
			}
			else if(c.isSecure())
			{
				System.out.println(c.getName()+" is secure cookie");
			}
			else if(c.getName().equalsIgnoreCase("session-id"))
			{
				System.out.println(c.getName()+" is Session cookie");
			}
			else if(c.getName().equalsIgnoreCase("session-id-time"))
			{
				System.out.println(c.getName()+" is Persistent cookie");
			}
			else if(c.getDomain().contains("ebay.com"))
			{
				System.out.println(c.getName()+" is Same-site cookie");
			}
			else
			{
				System.out.println(c.getName()+" is third-party cookie");
			}
		}
		//Close site
		driver.close();
	}
}
