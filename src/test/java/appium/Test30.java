package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Test30
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
		//Test automation
		try
		{
			Thread.sleep(10000);
			//Screen rotation automation
			String x=driver.getOrientation().name();
			System.out.println(x);
			if(x.equalsIgnoreCase("PORTRAIT"))
			{
				driver.rotate(ScreenOrientation.LANDSCAPE);
			}
			Thread.sleep(10000);
			String y=driver.getOrientation().name();
			System.out.println(y);
			if(y.equalsIgnoreCase("LANDSCAPE"))
			{
				driver.rotate(ScreenOrientation.PORTRAIT);
			}
			Thread.sleep(10000);
			//Operate app specified in desired capabilities and automate virtual keyboard
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(
					                 By.xpath("//*[@content-desc='username']")));
			driver.findElement(By.xpath("//*[@content-desc='username']")).click();
			if(driver.isKeyboardShown())
			{
				Thread.sleep(10000);
				driver.hideKeyboard();
				Thread.sleep(5000);
			}
			//Come to mobile home screen without closing app
			KeyEvent k=new KeyEvent(AndroidKey.HOME);
			driver.pressKey(k);
			Thread.sleep(5000);
			//back to work with app specified in desired capabilities
			driver.launchApp();
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