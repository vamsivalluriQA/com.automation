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

import io.appium.java_client.android.AndroidDriver;

public class Test45
{
	public static void main(String[] args) throws Exception
	{
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and VodQA app
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
		//verticalSwipe
		try
		{
			WebDriverWait w=new WebDriverWait(driver,10);
			w.until(ExpectedConditions.elementToBeClickable(
					                        By.xpath("//*[@text='LOG IN']"))).click();
			w.until(ExpectedConditions.elementToBeClickable(
									By.xpath("//*[@text='Vertical swiping']"))).click();
			//bottom to top
			while(2>1)
			{
				try
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(
                                             By.xpath("//*[contains(@text,'Karma')]")));
					break;
				}
				catch(Exception ex)
				{
					PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
			        Dimension size=driver.manage().window().getSize();
			        Point source=new Point(size.getWidth()-400,size.getHeight()-400);
			        Sequence s=new Sequence(finger,1);
			        s.addAction(finger.createPointerMove(Duration.ofMillis(0),
			                PointerInput.Origin.viewport(),source.x, source.y));
			    s.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			        s.addAction(new Pause(finger, Duration.ofMillis(100)));
			        s.addAction(finger.createPointerMove(Duration.ofMillis(600),
			                PointerInput.Origin.viewport(),source.x,source.y/2));
			      s.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			        driver.perform(Arrays.asList(s));
				}
			}
			Thread.sleep(5000);
			//top to bottom
			while(2>1)
			{
				try
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(
                                                          By.xpath("//*[@text=' C']")));
					break;
				}
				catch(Exception ex)
				{
					PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
			        Dimension size=driver.manage().window().getSize();
			        Point source=new Point(400,400);
			        Sequence s=new Sequence(finger,1);
			        s.addAction(finger.createPointerMove(Duration.ofMillis(0),
			                            PointerInput.Origin.viewport(),source.x, source.y));
			    s.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
			        s.addAction(new Pause(finger, Duration.ofMillis(100)));
			        s.addAction(finger.createPointerMove(Duration.ofMillis(600),
			                            PointerInput.Origin.viewport(),source.x,source.y*2));
			      s.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			        driver.perform(Arrays.asList(s));
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
}
