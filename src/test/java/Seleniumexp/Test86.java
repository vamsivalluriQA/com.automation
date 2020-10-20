package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test86
{
	public static void main(String[] args)
	{
		//Add chrome native command to stop web push notifications in chrome browser
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		//Open chrome browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in");
	}
}




