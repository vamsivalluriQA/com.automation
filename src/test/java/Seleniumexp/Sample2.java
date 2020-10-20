package Seleniumexp;

import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Sample2 extends Thread
{
	public void run()
	{
		System.setProperty("webdriver.opera.driver","D:\\operadriver_win64\\operadriver.exe");
		RemoteWebDriver driver=new OperaDriver();
		driver.get("http://www.amazon.in");
	}
}
