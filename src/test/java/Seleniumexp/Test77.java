package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test77
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		driver.executeAsyncScript(
			"window.setTimeout(function(){window.alert('kalam');},1000); window.alert('hi');");

	}

}




