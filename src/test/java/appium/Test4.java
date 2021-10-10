package appium;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Test4 
{
	public static void main(String[] args) throws Exception
	{
		//Take url of appium server started manually
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to android device and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
	    dc.setCapability("deviceName","emulator-5554");
	    dc.setCapability("platformName","android");
	    dc.setCapability("platformVersion","8.1.0");
	    dc.setCapability("appPackage","com.android.calculator2");
	    dc.setCapability("appActivity","com.android.calculator2.Calculator");
		//Launch browser in device through appium server
	    AppiumDriver driver=new AndroidDriver(u,dc);
		//Test automation
		

	}

}
