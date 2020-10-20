package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Test14 
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
		//Locate element via visual relations with other element in page
		WebElement e1=driver.findElement(By.className("hsuHs")); //search
		WebElement e2=driver.findElement(By.className("HPVvwb")); //mic
		//WebElement e3=driver.findElement(
				//RelativeLocator.withTagName("input").toRightOf(e1).toLeftOf(e2));
		//e3.sendKeys("abdul kalam");
	}

}








