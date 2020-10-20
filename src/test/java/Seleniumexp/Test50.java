package Seleniumexp;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test50
{
	public static void main(String[] args) throws Exception
	{
		Date today=new Date();
	    Date tomorrow=new Date(today.getTime()+(1000 * 60 * 60 * 24));
	    Cookie.Builder b=new Cookie.Builder("myCookie","my value"); //Name & value
	    Cookie newcookie=
	    	b.domain("www.magnitia.com").path("/").expiresOn(tomorrow).isSecure(true).build(); 
	    System.out.println("My new Cookie: "+newcookie);
	    //open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.magnitia.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Add cookie to browser
		driver.manage().addCookie(newcookie);
		//Collect all cookies, which are loaded along with home page
		Set<Cookie> s=driver.manage().getCookies();
		ArrayList<Cookie> l=new ArrayList<Cookie>(s);
		System.out.println("Count of all cookies is "+l.size());
		System.out.println("Cookies are:");
		for(Cookie c:l)
		{
			System.out.println(c.getName()+"---->"+c.getValue()+"--->"+c.getDomain());
		}
	}
}
