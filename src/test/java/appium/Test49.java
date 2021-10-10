package tests;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class Test49
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
		//MultiTouchAction
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.
	                elementToBeClickable(By.xpath("//*[@text='LOG IN']"))).click();
			wait.until(ExpectedConditions.
	                elementToBeClickable(MobileBy.AccessibilityId("slider1"))).click();
	        Thread.sleep(3000);
	        MobileElement s1=(MobileElement) driver.findElementByAccessibilityId("slider");
	        MobileElement s2=(MobileElement) driver.findElementByAccessibilityId("slider1");
	        Dimension size1=s1.getSize();
	        Dimension size2=s2.getSize();
	        //Define touch actions
	        TouchAction ta1=new TouchAction(driver);
	        ta1.press(ElementOption.element(s1,0,size1.height/2))
	                        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                        .moveTo(ElementOption.element(s1,size1.width-10,size1.height/2));
	        TouchAction ta2=new TouchAction(driver);
	        ta2.press(ElementOption.element(s2,0,size2.height/2))
	        				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
	                        .moveTo(ElementOption.element(s2,size2.width-10,size2.height/2));
	        //Perform all actions at a time
	        MultiTouchAction ma=new MultiTouchAction(driver);
	        ma.add(ta1).add(ta2).perform(); 
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
