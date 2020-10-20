package Seleniumexp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test53 
{
	public static void main(String[] args)
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().setScriptTimeout(1,TimeUnit.MILLISECONDS);
		//Launch site
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.name("email"));
		try
		{
			driver.executeScript("arguments[0].value='kalam'",e);
		}
		catch(Exception ex)
		{
			System.out.println("Javascript code is taking more than 1 millisecond");
		}
		//close site
		driver.close();
	}
}







