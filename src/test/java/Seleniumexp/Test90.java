package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test90
{
	public static void main(String[] args)
	{
		//Open browser 
		//without browser driver logs and without "controlled by automation code" notification
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		String[] s=new String[]{"enable-automation"};
		ChromeOptions co=new ChromeOptions();
		co.setExperimentalOption("excludeSwitches",s);
		ChromeDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
	}
}







