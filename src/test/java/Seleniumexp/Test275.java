package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test275
{
	public static void main(String[] args)
	{
		Thread th1=new Thread()
		{
			public void run()
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\vallu\\drivers\\chromedriver.exe");
				RemoteWebDriver driver=new ChromeDriver();
				driver.get("http://www.magnitia.com");
			}
		};
		
		Thread th2=new Thread()
		{
			public void run()
			{
				System.setProperty("webdriver.opera.driver","E:\\batch248\\operadriver_win64\\operadriver.exe");
				RemoteWebDriver driver=new OperaDriver();
				driver.get("http://www.amazon.in");
			}
		};
		th1.start(); 
		th2.start();
        System.setProperty("webdriver.gecko.driver","E:\\batch248\\geckodriver.exe");
		RemoteWebDriver driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
	}

}
