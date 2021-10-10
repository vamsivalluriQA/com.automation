package appium;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Test2
{
	public static void main(String[] args) throws Exception
	{
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to android device and app to be installed
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
	    dc.setCapability("deviceName","emulator-5554");
	    dc.setCapability("platformName","android");
	    dc.setCapability("platformVersion","8.1.0");
	    dc.setCapability("app","E:\\batch249\\vodqa.apk");
		//Launch app in device through appium server
	    AppiumDriver driver;
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
		//Test automation
		//driver.closeApp();
		Thread.sleep(5000);
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe"); 
	}
}







