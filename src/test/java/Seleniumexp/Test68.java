package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test68
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		//Page scroll down to get visibility of element
		Actions a=new Actions(driver);
		for(int i=1;i<=10;i++)
		{
			a.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(1000);
		}
		//Element scroll down
		WebElement e=driver.findElement(By.xpath("(//pre[contains(@class,'prettyprint')])[1]"));
		for(int i=1;i<=10;i++)
		{
			a.sendKeys(e,Keys.ARROW_DOWN).perform();
			a.pause(1000).perform();; //by default milli seconds
		}
		//Element scroll top
		for(int i=1;i<=10;i++)
		{
			a.sendKeys(e,Keys.ARROW_UP).perform();
			a.pause(1000).perform();; //by default milli seconds
		}
		//Element scroll right
		for(int i=1;i<=10;i++)
		{
			a.sendKeys(e,Keys.ARROW_RIGHT).perform();
			a.pause(1000).perform();; //by default milli seconds
		}
		//Element scroll left
		for(int i=1;i<=10;i++)
		{
			a.sendKeys(e,Keys.ARROW_LEFT).perform();
			a.pause(1000).perform();; //by default milli seconds
		}
	}
}













