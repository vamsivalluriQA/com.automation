package tests;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Test48
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
		//using "TouchAction" class methods
		try
		{
			Thread.sleep(10000);
			WebDriverWait wait=new WebDriverWait(driver, 30);
			driver.findElementByXPath("//*[@text='LOG IN']").click();
			wait.until(ExpectedConditions.
	                elementToBeClickable(MobileBy.AccessibilityId("slider1"))).click();
	        Thread.sleep(3000);
	        MobileElement s=(MobileElement) driver.findElementByAccessibilityId("slider");
	        Dimension size=s.getSize();
	        Point p=s.getLocation(); //left top coordinates of an element in appscreen
	        //left to right
	        swipe(driver,
	        	 p.getX(),p.getY()+size.getHeight()/2, 
	        	 p.getX()+size.getWidth()-10,p.getY()+size.getHeight()/2);
	        Thread.sleep(10000);
	        //right to left
	        swipe(driver,
		        	 p.getX()+size.getWidth()-10,p.getY()+size.getHeight()/2,
		        	 p.getX(),p.getY()+size.getHeight()/2);
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
	public static void swipe(AndroidDriver driver, int x1, int y1, int x2, int y2)
	{
		TouchAction ta=new TouchAction(driver);
		PointOption po=new PointOption();
		PointOption po1=po.withCoordinates(x1, y1);
		PointOption po2=po.withCoordinates(x2, y2);
		ta.press(po1)
             .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
             .moveTo(po2)
             .release().perform();
	}
}
