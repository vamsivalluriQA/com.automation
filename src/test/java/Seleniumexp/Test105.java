package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test105
{
	public static void main(String[] args)
	{
		//Open chrome browser
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site by giving credentials via URL to avoid authentication pop-up window
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//continue page automation
	}
}










