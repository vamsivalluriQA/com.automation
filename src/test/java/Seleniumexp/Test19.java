package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test19 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.yahoomail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("magnitiasdet");
		driver.findElement(By.name("signin")).submit();

	}

}





