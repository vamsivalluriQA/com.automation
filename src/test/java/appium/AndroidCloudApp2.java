package examples;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Point;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidCloudApp2
{
	public static void main(String[] args) throws Exception
	{
		//Desired capabilities related to real android device(as paer availaility) in cloud
		String APP="https://github.com/appium/android-apidemos/releases/download/v3.1.0/ApiDemos-debug.apk";
	    DesiredCapabilities caps=DesiredCapabilities.android();
	    caps.setCapability("username", "rajashekar2020");
	    caps.setCapability("accessKey", "fd8db09a-9a7b-4caf-ba12-7bccb06ea078");
	    caps.setCapability("deviceName","Samsung Galaxy M01 Core");
	    caps.setCapability("deviceOrientation", "portrait");
	    caps.setCapability("browserName", "");
	    caps.setCapability("platformVersion","8.1");
	    caps.setCapability("platformName","Android");
	    caps.setCapability("app",APP);
	    //Give Cloud(Sauce Labs) details
	  	String USERNAME="rajashekar2020";
	  	String ACCESSKEY="fd8db09a-9a7b-4caf-ba12-7bccb06ea078";
	  	String endpoint="http://"+USERNAME+":"+ACCESSKEY+"@ondemand.saucelabs.com:80/wd/hub";
	  	URL u=new URL(endpoint);
	  	AndroidDriver driver=new AndroidDriver(u,caps);
	  	WebDriverWait wait=new WebDriverWait(driver,10);
	  	System.out.println("App launched");
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	    		                                  MobileBy.AccessibilityId("Views"))).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(
	    		                              MobileBy.className("android.widget.ListView")));
	    //bottom to top
		while(2>1)
		{
			try
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						MobileBy.AccessibilityId("TextClock"))).click();
				break;
			}
			catch(Exception ex)
			{
				TouchAction ta=new TouchAction(driver);
				Point p=new Point(535,2535);
				ta.press(PointOption.point(p))
				  .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				  .moveTo(PointOption.point(0,-1000))
				  .perform();
			}
		}
	    String msg=wait.until(ExpectedConditions.presenceOfElementLocated(
	    				MobileBy.className("android.widget.LinearLayout"))).getText();
	    System.out.println(msg);
	    driver.quit();
	}
}
