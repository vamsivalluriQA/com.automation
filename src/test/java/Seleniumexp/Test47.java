package Seleniumexp;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test47
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
		//Launch site and do login using valid data
		driver.get("http://www.gmail.com");
		Thread.sleep(5000); 
        driver.findElement(By.name("identifier")).sendKeys("seleniumfullstack");
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("password")).sendKeys("nareshyadav");
        driver.findElement(By.xpath("//*[text()='Next']")).click();
        Thread.sleep(10000);
		//Collect all cookies related to that site Mailbox page
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
			else if(c.getDomain().contains("google.com"))
			{
				System.out.println(c.getName()+" is Super cookie");
			}
			else if(c.getDomain().contains("gmail.com"))
			{
				System.out.println(c.getName()+" is Same-site cookie");
			}
			else
			{
				System.out.println(c.getName()+" is third-party cookie");
			}
		}
		//Do Logout
		driver.findElement(By.xpath(
				"//*[starts-with(@aria-label,'Google Account')]/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();

	}

}
