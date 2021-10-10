package tests;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Test26
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
			//vertical swipe
			//locate an visible element
			MobileElement ele=(MobileElement) driver.findElementByXPath(
					                                      "//*[@content-desc='webView']");
			//Identify center of that element
	        Point source=ele.getCenter();
	        //create finger touch object
	        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
	        //Create sequence of finger events
	        Sequence dragNDrop=new Sequence(finger,0);
	        //event-1
	        Interaction i1=finger.createPointerMove(Duration.ofMillis(0),
		            PointerInput.Origin.viewport(),
		            source.x,
		            source.y);
	        dragNDrop.addAction(i1);
	        //event-2
	        Interaction i2=finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg());
	        dragNDrop.addAction(i2);
	        //event-3
	        Interaction i3=finger.createPointerMove(Duration.ofMillis(600),
	        		PointerInput.Origin.viewport(), 
	        		source.x, 
	        		source.y-600);
	        dragNDrop.addAction(i3);
	        //event-4
	        Interaction i4=finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg());
	        dragNDrop.addAction(i4);
	        //perform 4 events of sequence
	        driver.perform(Arrays.asList(dragNDrop));
			Thread.sleep(5000);
			//Locate required view and click
			driver.findElementByXPath("//*[@content-desc='wheelPicker']").click();
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			Thread.sleep(5000);
		}
		//Close App
		driver.quit();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe"); 
	}
}