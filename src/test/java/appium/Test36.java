package tests;

import java.net.URL;

import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test36 
{
	public static void main(String[] args) throws Exception
	{
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","RZ8M70HG1QK");
	    dc.setCapability("platformName","android");  
	    dc.setCapability("platformVersion","10");
	    dc.setCapability("locationServicesEnabled",true);
		dc.setCapability("locationServicesAuthorized",true);
		dc.setCapability("noReset","true");
		dc.setCapability("fullReset","false"); 
		dc.setCapability("appPackage","com.google.android.apps.maps");
		dc.setCapability("appActivity","com.google.android.maps.MapsActivity");
		//Launch app in ARD through appium server
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
		//Automation
		try
		{
			Thread.sleep(20000);
			//Get location
			Location l1=driver.location();
			System.out.println(l1.getLatitude());
			System.out.println(l1.getLongitude());
			System.out.println(l1.getAltitude());
			//change Location in map using given Latitude,Longitude,Altitude
			Location l2=new Location(27.16544,78.05452,100);
			driver.setLocation(l2);
			Thread.sleep(20000);
			//Get changed location
			Location l3=driver.location();
			System.out.println(l3.getLatitude());
			System.out.println(l3.getLongitude());
			System.out.println(l3.getAltitude());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//close app
		driver.closeApp();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
