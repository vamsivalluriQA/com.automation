package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test64
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//Close banner
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		Thread.sleep(5000);
		//Move mouse pointer to an element
		WebElement e=driver.findElement(By.xpath("//span[contains(text(),'Baby')]"));
		Actions a=new Actions(driver);
		a.moveToElement(e,10,10).perform();
	}

}








