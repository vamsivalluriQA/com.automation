package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test277
{
	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","E:\\batch248\\chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		try
		{
			String x=driver.findElement(By.name("identifier")).getText();
			if(x.equals(""))
			{
				Exception e=new Exception();
				throw e;
			}
		}
		catch(Exception e)
		{
			System.out.println("Blank value");
		}
		//close site
		driver.close();
	}
}










