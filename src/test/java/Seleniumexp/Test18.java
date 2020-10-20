package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test18 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);
		//Click on register link
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(5000);
		//Fill password
		driver.findElement(By.name("password")).sendKeys("kalam",Keys.chord(Keys.CONTROL,"a"));
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(Keys.chord(Keys.CONTROL,"c"));
		Thread.sleep(5000);
		driver.findElement(By.name("confirmPassword")).sendKeys(Keys.chord(Keys.CONTROL,"v"));
	}
}







