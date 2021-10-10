package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Test33
{
	public static void main(String[] args) throws Exception
	{
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
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
			//Come to Home
			KeyEvent k=new KeyEvent(AndroidKey.HOME);
			driver.pressKey(k);
			Thread.sleep(10000);
			//Open notofications
			driver.openNotifications();
			Thread.sleep(10000);
			try
			{
				WebElement e=driver.findElement(By.xpath("//*[@text='CLEAR ALL']"));
				e.click();
				Thread.sleep(5000);
				driver.pressKey(k); //BACK TO HOME
			}
			catch(Exception exc)
			{
				driver.pressKey(k); //BACK TO HOME
			}
			Thread.sleep(10000);
			//Get details of device
			String x=driver.getRemoteAddress().getProtocol();
			System.out.println(x);
			String y=driver.getRemoteAddress().getHost();
			System.out.println(y);
			String z=driver.getRemoteAddress().getPath();
			System.out.println(z);
			int w=driver.getRemoteAddress().getPort();
			System.out.println(w);
			long a=driver.getDisplayDensity(); 
			System.out.println(a);
			String b=driver.getDeviceTime();
			System.out.println(b);
			String c=driver.getPlatformName();
			System.out.println(c);
			String an=driver.getAutomationName();
			System.out.println(an);
			double bc=driver.getBatteryInfo().getLevel();
			System.out.println(bc);
			//Get device lock details
			if(driver.isDeviceLocked()==false)
			{
				driver.lockDevice();
				Thread.sleep(10000);
				driver.unlockDevice();
			}
			//Back to work with app specified in desired capabilities
			driver.launchApp();
			Thread.sleep(10000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Close App
		driver.closeApp();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe"); 
	}
}