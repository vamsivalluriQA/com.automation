package tests;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test37
{
	public static void main(String[] args) throws Exception
	{
		//Start appium sever
		Runtime.getRuntime().exec(
                   "cmd.exe /c start cmd.exe /k \"appium --chromedriver-executable E:\\batch249\\chromedriver.exe\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and browser only
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
		dc.setCapability("deviceName","RZ8M70HG1QK");
		dc.setCapability("platformName","android");  
		dc.setCapability("platformVersion","10");
		//Launch chrome in ARD through appium server
		AndroidDriver driver;
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
			}
		}
		//context for hybrid apps
		Thread.sleep(10000);
		Set s1=driver.getContextHandles(); //get all possible
		System.out.println(s1);
		String x=driver.getContext(); //current context
		System.out.println(x);
		/*driver.context("NATIVE_APP"); //to change context
		String y=driver.getContext();
		System.out.println(y);
		if(driver.isBrowser()) //to check in web context
		{
			driver.close();
			System.out.println("closed as site");
		}
		else
		{
			driver.closeApp();
			System.out.println("closed as app");
		} */
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
