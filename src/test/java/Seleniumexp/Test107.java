package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test107
{
	public static void main(String[] args)
	{
		//Open chrome browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site by giving credentials via URL to avoid authentication pop-up window
		String x="admin";
		String y="admin";
		driver.get("http://"+x+":"+y+"@the-internet.herokuapp.com/basic_auth");
		//continue page automation
	}
}










