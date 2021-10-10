package tests;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Test3 
{
	public static void main(String[] args) throws Exception
	{
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium --chromedriver-executable E:\\batch249\\chromedriver.exe\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to android device and browser
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
	    dc.setCapability("deviceName","RZ8M70HG1QK");
	    dc.setCapability("platformName","android");
	    dc.setCapability("platformVersion","10");
		//Launch browser in device through appium server
	    AppiumDriver driver;
		while(2>1)
		{
			try
			{
			   driver=new AndroidDriver(u,dc);
			   break; //terminate from current loop
			}
			catch(Exception ex)
			{
			}
		} 
		//Test automation
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		driver.close();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe"); 
	}
}
