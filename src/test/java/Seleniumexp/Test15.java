package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.locators.RelativeLocator;
//import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

public class Test15 
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
		//Define locator
		By b1=By.className("hsuHs");
		//Locate element
		WebElement e1=driver.findElement(b1); //search
		//Define locator
		By b2=By.className("HPVvwb");
		//Locate element
		WebElement e2=driver.findElement(b2); //mic
		//Define locator
		//RelativeBy b3=RelativeLocator.withTagName("input").toRightOf(e1).toLeftOf(e2);
		//Locate element
		//WebElement e3=driver.findElement(b3);
		//e3.sendKeys("abdul kalam");
	}
}





