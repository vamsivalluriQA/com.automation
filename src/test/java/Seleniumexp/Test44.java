package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test44
{
	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.navigate().to("http://www.yahoomail.com");
		Thread.sleep(5000);
		driver.navigate().back(); //gmail
		Thread.sleep(5000);
		driver.navigate().forward(); //yahoo
		Thread.sleep(5000);
		driver.navigate().refresh(); //yahoo
	}
}






