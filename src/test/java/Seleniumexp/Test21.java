package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test21
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
		//Locate an element
		WebElement e=driver.findElement(By.linkText("Gmail"));
		//before focus
		String x1=e.getCssValue("text-decoration");
		String y1=e.getCssValue("opacity");
		System.out.println(x1);
		System.out.println(y1);
		//Send mouse focus to element
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
		Thread.sleep(5000);
		//After focus
		String x2=e.getCssValue("text-decoration");
		String y2=e.getCssValue("opacity");
		System.out.println(x2);
		System.out.println(y2);
		//validations
		if(x2.contains("underline"))
		{
			System.out.println("Underline came after getting focus, so test passed");
		}
		else
		{
			System.out.println("No underline after getting focus, so test failed");
		}
		float f=Float.parseFloat(y2);
		if(f!=1)
		{
			System.out.println("Color shaded after getting focus, so test passed");
		}
		else
		{
			System.out.println("No Color shade after getting focus, so test failed");
		}
		//Close site
		driver.close();
	}
}






