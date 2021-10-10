package tests;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test46
{
	public static void main(String[] args) throws Exception
	{
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and Google Pkay store app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","RZ8M70HG1QK");
	    dc.setCapability("platformName","android");
	    dc.setCapability("platformVersion","10");
		dc.setCapability("appPackage","com.android.vending");
	    dc.setCapability("appActivity","com.android.vending.AssetBrowserActivity");
		//Launch app in device through appium server by creating driver object
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
		//horizontal Swiping
		try
		{
			Thread.sleep(10000);
			WebDriverWait w=new WebDriverWait(driver,10);
			MobileElement panel=(MobileElement) driver.findElementByXPath(
					      "(//*[@resource-id='com.android.vending:id/cluster_content'])[1]");
	        Point center=panel.getCenter();
			//right to left swipe
			while(2>1)
			{
				try
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(
                               By.xpath("//*[contains(@content-desc,'Candy Crush')]")));
					break;
				}
				catch(Exception ex)
				{
			        myswipe(driver, center.x+400, center.y,center.x-400,center.y);			        
				}
			}
			Thread.sleep(5000);
			//left to right swipe
			while(2>1)
			{
				try
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(
                              By.xpath("//*[contains(@content-desc,'Talking Tom')]")));
					break;
				}
				catch(Exception ex)
				{
			        myswipe(driver, center.x-400,center.y, center.x+400,center.y);
				}
			}
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

	public static void myswipe(AndroidDriver driver, int x1, int y1, int x2, int y2) 
	{
		PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence s=new Sequence(finger,1);
        s.addAction(finger.createPointerMove(Duration.ofMillis(0),
                                               PointerInput.Origin.viewport(),x1, y1));
        s.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        s.addAction(new Pause(finger, Duration.ofMillis(100)));
        s.addAction(finger.createPointerMove(Duration.ofMillis(600),
                                                PointerInput.Origin.viewport(),x2,y2));
        s.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(s));	
	}
}
