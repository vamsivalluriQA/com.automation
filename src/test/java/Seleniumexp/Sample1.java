package Seleniumexp;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sample1 extends Thread
{
	public void run()
	{
		System.setProperty("webdriver.gecko.driver","E:\\batch248\\geckodriver.exe");
		RemoteWebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
	}
}
