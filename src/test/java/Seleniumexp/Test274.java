package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test274 extends Thread
{
	public void run()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vallu\\drivers\\chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		
	}
	public static void main(String[] args)
	{
		Test274 t1=new Test274();  
        t1.start(); 
        System.setProperty("webdriver.gecko.driver","E:\\batch248\\geckodriver.exe");
		RemoteWebDriver driver=new FirefoxDriver();
	}

}
