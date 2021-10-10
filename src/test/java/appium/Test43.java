package tests;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Test43
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
		//Zoom
		try
		{
			WebDriverWait w=new WebDriverWait(driver,30);
			w.until(
			ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='LOG IN']"))).click();
			w.until(
			ExpectedConditions.elementToBeClickable(
					                          MobileBy.AccessibilityId("photoView"))).click();
			//logic
	        Thread.sleep(3000);
	        PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
	        PointerInput finger2=new PointerInput(PointerInput.Kind.TOUCH,"finger2");
	        Dimension size=driver.manage().window().getSize();
	        Point source=new Point(size.getWidth(),size.getHeight());
	        
	        Sequence s1=new Sequence(finger1,1);
	        s1.addAction(finger1.createPointerMove(Duration.ofMillis(0),
	                PointerInput.Origin.viewport(), source.x/2, source.y/2));
	        s1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        s1.addAction(new Pause(finger1, Duration.ofMillis(100)));
	        s1.addAction(finger1.createPointerMove(Duration.ofMillis(600),
	                PointerInput.Origin.viewport(),source.x/3,source.y/3));
	        s1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        
	        Sequence s2= new Sequence(finger2, 0);
	        s2.addAction(finger2.createPointerMove(Duration.ofMillis(0),
	                PointerInput.Origin.viewport(), source.x/2, source.y/2));
	        s2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        s2.addAction(new Pause(finger2, Duration.ofMillis(100)));
	        s2.addAction(finger2.createPointerMove(Duration.ofMillis(600),
	                PointerInput.Origin.viewport(), source.x*3/4, source.y*3/4));
	        s2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        driver.perform(Arrays.asList(s1,s2));
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
