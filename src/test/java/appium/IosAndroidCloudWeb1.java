package examples;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IosAndroidCloudWeb1
{
	public static void main(String[] args) throws Exception
	{
		//Take the platform
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter android or ios");
		String platform=sc.nextLine();
		sc.close();
		//Give Cloud(Sauce Labs) details
		String USERNAME="vinod111";
		String ACCESSKEY="49a25702-1dc4-40b6-9195-066c5501d8cf";
		URL u=new URL("http://"+USERNAME+":"+ACCESSKEY+"@ondemand.saucelabs.com:80/wd/hub");
		//Declare objects glabally
		DesiredCapabilities caps=null;
		AppiumDriver driver=null; 
		if(platform.equalsIgnoreCase("ios"))
		{
			//Capabilities related to Safari and ios device in cloud
			caps=DesiredCapabilities.iphone();
			caps.setCapability("appiumVersion","1.17.1");
			caps.setCapability("deviceName","iPhone 8 Simulator");
			caps.setCapability("deviceOrientation","portrait");
			caps.setCapability("platformVersion","13.4");
			caps.setCapability("platformName","iOS");
			caps.setCapability("browserName","Safari");
			//Connect to cloud to access "iPhone 8 Simulator" for web site tesing
			driver=new IOSDriver(u,caps);
		}
		else
		{
			caps=DesiredCapabilities.android();
			caps.setCapability("appiumVersion","1.17.1");
			caps.setCapability("deviceName","Samsung Galaxy S9 WQHD GoogleAPI Emulator");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("browserName","Chrome");
			caps.setCapability("platformVersion", "9.0");
			caps.setCapability("platformName","Android");
			//Connect to cloud to access "Samsung Galaxy S9 WQHD GoogleAPI Emulator" 
			//for web site tesing
			driver=new AndroidDriver(u,caps);
		}
		//Launch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//Validation
		if(driver.getTitle().equals("Google"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
		//Close site
		driver.quit();
	}
}
