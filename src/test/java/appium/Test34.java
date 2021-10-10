package tests;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;

public class Test34
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
	    dc.setCapability("appPackage","com.jio.media.ondemand");
	    dc.setCapability("appActivity",
	    		        "com.jio.media.mobile.apps.jioondemand.landing.MainLandingActivity");
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
		//Test automation on jio cinema app
		//Jio cinema app can work with mobile data only, so go to off airplane mode and wifi
		try
		{
			Thread.sleep(10000);
			//Get connection details(WIFI,DATA,AIRPLANE) related to device
			ConnectionState con=driver.getConnection();
			//about AIRPLANE
			if(con.isAirplaneModeEnabled())
			{
				System.out.println("AIRPLANE mode is in on, so i am going to OFF");
				//OFF AirplaneMode
				driver.toggleAirplaneMode();
				Thread.sleep(10000);
			}
			else
			{
				System.out.println("AIRPLANE mode is in off");
			}
			//about WIFI
			if(con.isWiFiEnabled())
			{
				System.out.println("WIFI is in on, so go to off");
				//Off WIFI
				driver.toggleWifi();
				Thread.sleep(10000);
			}
			else
			{
				System.out.println("WIFI is already in off");
			}
			//about DATA
			if(con.isDataEnabled())
			{
				System.out.println("DATA is in on");
			}
			else
			{
				System.out.println("DATA is in off");
				//ON mobile data
				driver.toggleData();
				Thread.sleep(10000);
			}
			driver.findElementByXPath("//*[@text='Allow']").click();
			Thread.sleep(5000);
			driver.findElementByXPath("//*[@text='Deny']").click();
			Thread.sleep(5000);
			driver.findElementByXPath("//*[@text='JioCinema']").click();
			Thread.sleep(5000);
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