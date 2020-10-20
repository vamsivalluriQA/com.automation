package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test39
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://accounts.google.com/ServiceLogin/identifier");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//operate active element
		driver.switchTo().activeElement().sendKeys("456678");

	}

}
