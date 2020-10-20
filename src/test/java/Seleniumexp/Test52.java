package Seleniumexp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test52
{
	public static void main(String[] args)
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(1,TimeUnit.SECONDS);
		//Launch site
		try
		{
			driver.get("http://www.facebook.com");
		}
		catch(Exception ex)
		{
			System.out.println("facebook homepage loading is taking more than 1 second");
		}
		//further code
		driver.manage().window().maximize();
		
	}

}








