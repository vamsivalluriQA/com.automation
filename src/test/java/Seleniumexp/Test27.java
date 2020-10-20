package Seleniumexp;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test27
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Links testing to find broken links
		int hyperlinkscount=0;
		int workinglinks=0;
		int brokenlinks=0;
		//Collect all link type elements
		List<WebElement> l=driver.findElements(By.xpath(
				      "(//a)|(//link)|(//base)|(//script)|(//area)|(//href)|(//img)"));
		//Check for "href" attribute availability for each collected element
		for(WebElement e:l)
		{
			//Check for availability of "href" attribute for current element
			if(e.getAttribute("href")!=null)
			{
				//Get "href" attribute value
				String x=e.getAttribute("href");
				//Check for blank value
				if(!x.equals(""))
				{
					//Check for http/https in that value
					if(x.startsWith("http") || x.startsWith("https"))
					{
						hyperlinkscount++;
						URL u=new URL(x);
						HttpURLConnection con=(HttpURLConnection) u.openConnection();
						con.connect(); //connect to server at given address/URL
						try
						{
							String res=con.getResponseMessage();
							con.disconnect();
							if(res.equalsIgnoreCase("OK") ||
									res.equalsIgnoreCase("Accepted") ||
									res.equalsIgnoreCase("Found") ||
									res.equalsIgnoreCase("200") ||
									res.equalsIgnoreCase("202") ||
									res.equalsIgnoreCase("302"))
							{
								workinglinks++;
							}
							else
							{
								brokenlinks++;
								System.out.println(x+" return "+res);
							}
						}
						catch(Exception ex)
						{
							con.disconnect();
							brokenlinks++;
							System.out.println(x);
						}
					}
				}
			}
		} //loop ending
		//Display output
		System.out.println("Total link type elements are "+hyperlinkscount);
		System.out.println("Working links are "+workinglinks);
		System.out.println("Broken links are "+brokenlinks);
		//Close site
		driver.close();
	}
}











