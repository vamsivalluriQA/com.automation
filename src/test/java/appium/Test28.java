package tests;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test28
{
	public static void main(String[] args) throws Exception
	{
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ESPRESSO);
		dc.setCapability("forceEspressRebuild","true");
		dc.setCapability("showGradleLog","true");
	    dc.setCapability("deviceName","emulator-5554");
	    dc.setCapability("platformName","android");  
	    dc.setCapability("platformVersion","8.1.0");
	    dc.setCapability("appPackage","com.vodqareactnative");
	    dc.setCapability("appActivity","com.vodqareactnative.MainActivity");
		//Launch app in device through appium server
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
		//Test automation
		try
		{
			Thread.sleep(10000);
			driver.findElementByXPath("//*[@text='LOG IN']").click();
			Thread.sleep(5000);
			List<WebElement> l=driver.findElementsByXPath("//*[@content-desc='scrollView']/com.facebook.react.views.view.ReactViewGroup/com.facebook.react.views.view.ReactViewGroup");
			System.out.println(l.size());
			for(WebElement e:l)
			{
				String x=e.getAttribute("content-desc");
				System.out.println(x);
			}
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Close App
		driver.quit();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe"); 
	}
}