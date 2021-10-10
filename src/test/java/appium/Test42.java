package tests;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test42
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
		//longpress automation
		try
		{
			WebDriverWait w=new WebDriverWait(driver, 30);
			w.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@text='LOG IN']")));
			driver.findElementByXPath("//*[@text='LOG IN']").click();
			w.until(ExpectedConditions.elementToBeClickable(
					                          By.xpath("//*[@content-desc='longPress']")));
			driver.findElement(By.xpath("//*[@content-desc='longPress']")).click();
			w.until(ExpectedConditions.elementToBeClickable(
					                                By.xpath("//*[@text='Long Press Me']")));
			//logic
	        MobileElement e=(MobileElement) driver.findElement(By.xpath(
	        		                                          "//*[@text='Long Press Me']"));
	        Point source=e.getCenter();
	        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
	        Sequence s=new Sequence(finger,1);
	        s.addAction(finger.createPointerMove(Duration.ofMillis(0),
	                             PointerInput.Origin.viewport(),source.x, source.y));
	        s.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        s.addAction(new Pause(finger,Duration.ofMillis(600))); //wait
	        s.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        driver.perform(Arrays.asList(s));
	        try
	        {
	        	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	        			                      "//*[contains(@text,'you pressed me hard')]")));
	        	System.out.println("Longpress Test Passed");
	        	driver.findElement(By.xpath("//*[@text='OK']")).click();
	        }
	        catch(Exception ex)
	        {
	        	System.out.println("Longpress Test failed");
	        	File src=driver.getScreenshotAs(OutputType.FILE);
                File dest=new File("longpressdefectscreen.png");
                FileHandler.copy(src,dest);
	        }
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
