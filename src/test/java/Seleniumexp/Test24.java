package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test24 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//Locate Userid
		WebElement e1=driver.findElement(By.name("identifier"));
		if(e1.isDisplayed())
		{
			if(e1.isEnabled())
			{
				System.out.println("Userid is visible and enabled");
			}
			else
			{
				System.out.println("Userid is visible but disabled");
			}
		}
		else
		{
			System.out.println("Userid is hidden");
		}
		//Locate Password
		WebElement e2=driver.findElement(By.name("hiddenPassword"));
		if(e2.isDisplayed())
		{
			if(e2.isEnabled())
			{
				System.out.println("Password is visible and enabled");
			}
			else
			{
				System.out.println("Password is visible but disabled");
			}
		}
		else
		{
			System.out.println("Password is hidden");
		}
		driver.close();
	}
}





