package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test76 
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser and launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.executeScript("window.alert('site is ready to launch');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.get(
				"https://stackoverflow.com/questions/38653910/actions-click-script-selenium");
		Thread.sleep(5000);
		driver.executeScript("window.alert('element is ready to watch');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		//Get visibility of element of page in desktop 
		WebElement e=driver.findElement(By.xpath("(//pre)[1]"));
		driver.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(5000);
		//element Scroll down
		driver.executeScript("window.alert('element is ready to scroll down');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.executeScript("var x=arguments[0].scrollHeight; arguments[0].scrollTop=x",e);
		Thread.sleep(5000);
		//element scroll up
		driver.executeScript("window.alert('element is ready to scroll up');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.executeScript("arguments[0].scrollTop=0",e);
		Thread.sleep(5000);
		//element scroll right
		driver.executeScript("window.alert('element is ready to scroll right');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.executeScript("var x=arguments[0].scrollWidth; arguments[0].scrollLeft=x",e);
		Thread.sleep(5000);
		//element scroll left
		driver.executeScript("window.alert('element is ready to scroll left');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.executeScript("arguments[0].scrollLeft=0",e);
		Thread.sleep(5000);
		//close site
		driver.executeScript("window.alert('site is going to close');");
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss();
		driver.close();
	}
}
