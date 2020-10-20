package Seleniumexp;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test49
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");          
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //Delete all existing cookies
        driver.manage().deleteAllCookies();
        //Launch site
        driver.get("http://www.google.co.in");
        Thread.sleep(5000); 
        //Add cookie
        Cookie nc=new Cookie("mycookie","magnitia"); //new cookie with name and value
        driver.manage().addCookie(nc);
        //Collect all cookies related to that site page
        Set<Cookie> cl1=driver.manage().getCookies();
        ArrayList<Cookie> l1=new ArrayList<Cookie>(cl1);
        System.out.println("Count of Cookies is "+l1.size());
        for(Cookie c:l1)
        {
        	System.out.println(c.getName()+"----->"+c.getValue());
        }
        System.out.println("After deletion:");
        //delete specific cookie by giving name
        driver.manage().deleteCookieNamed("UULE");
        //delete specific cookie by giving Cookie class object
        Cookie ec=driver.manage().getCookieNamed("mycookie"); 
        driver.manage().deleteCookie(ec);
        //Collect all cookies related to that site page
        Set<Cookie> cl2=driver.manage().getCookies();
        ArrayList<Cookie> l2=new ArrayList<Cookie>(cl2);
        System.out.println("Count of Cookies after some cookies deletion is "+l2.size());
        for(Cookie c:l2)
        {
        	System.out.println(c.getName()+"---->"+c.getValue());
        }
        //Close site
        driver.close();
	}
}


