package tests;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Test39
{
	public static void main(String[] args) throws Exception
	{
		//Site is different for computer and mobile
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter environment like computer/mobile");
		String en=sc.nextLine();
		//Automation
		if(en.equalsIgnoreCase("mobile"))
		{
			//Start appium sever
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium --chromedriver-executable E:\\batch249\\chromedriver.exe\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Define desired capabilities related to device and chrome browser
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			dc.setCapability("deviceName","xxxxxxxx");
			dc.setCapability("platformName","android");  
			dc.setCapability("platformVersion","xx");
			//Launch chrome in ARD through appium server by creating driver object
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
			Thread.sleep(10000);
			//Launch site
			driver.get("http://www.youtube.com");
			//Change current context "CHROMIUM" to required context "NATIVE_APP"
			driver.context("NATIVE_APP");
			//search for video
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					                                     "//*[@text='Search YouTube']")));
			driver.findElement(By.xpath("//*[@text='Search YouTube']")).click();
			try
			{
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						                          "//*[@class='android.widget.EditText']")));
				driver.findElement(By.xpath("//*[@class='android.widget.EditText']"))
	                                                   .sendKeys("abdul kalam sir speeches");
			}
			catch(Exception ex)
			{
				driver.findElement(By.xpath(
			       "//*[@resource-id='com.android.chrome:id/tab_switcher_button']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						                                   "//*[@text='Search YouTube']")));
				driver.findElement(By.xpath("//*[@text='Search YouTube']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						                          "//*[@class='android.widget.EditText']")));
				driver.findElement(By.xpath("//*[@class='android.widget.EditText']"))
                                                       .sendKeys("abdul kalam sir speeches");
			}
			w.until(ExpectedConditions.elementToBeClickable(By.xpath(
                                                           "//*[@text='Search YouTube']")));
			driver.findElement(By.xpath("//*[@text='Search YouTube']")).click();
			//Start video
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					                 "//*[contains(@text,'at European Parliament')]")));
			driver.findElement(By.xpath("//*[contains(@text,'at European Parliament')]"))
			                                                                    .click();
			Thread.sleep(10000); //manditory waiting before going to pause
			//pause video via double tap on that video body
			MobileElement e=(MobileElement) driver.findElementByAndroidUIAutomator(
					                "new UiSelector().resourceId(\"player-container-id\")");
			Point source=e.getCenter(); //center of video body
	        PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH,"finger");
	        Sequence s=new Sequence(finger,1); //for required actions(1 is default)
	        //action-1(Move finger to center of video body without delay)
	        s.addAction(finger.createPointerMove(Duration.ofMillis(0),
	                    PointerInput.Origin.viewport(), source.x, source.y));
	        //action-2(start finger press)
	        s.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        //action-3(few milli seconds delay)
	        s.addAction(new Pause(finger, Duration.ofMillis(200)));
	        //action-4(release finger press)
	        s.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        //action-5(few milliseconds delay)
	        s.addAction(new Pause(finger, Duration.ofMillis(40)));
	        //action-6(start finger press)
	        s.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        //action-7(few milli seconds delay)
	        s.addAction(new Pause(finger, Duration.ofMillis(200)));
	        //action-8(release finger press) 
	        s.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	        //Perform all actions sequence
	        driver.perform(Arrays.asList(s));
			Thread.sleep(10000); //manditory waiting to play
			//resume video
			driver.findElement(By.xpath("//*[contains(@text,'Play video')]")).click();
			Thread.sleep(10000); //manditory waiting to continue play
			//Change context to CHROMIUM and close browser
			driver.context("CHROMIUM");
			driver.close();
			//Stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
		else     //computer
		{
			//swd and sikulix
			//Launch site(SWD)
			System.setProperty("webdriver.chrome.driver","E:\\batch249\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.youtube.com");
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
			//Search for a video(SWD)
			driver.findElement(By.name("search_query")).sendKeys("abdul kalam sir speeches",
					                                                             Keys.ENTER);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			                      "//*[contains(text(),'at European Parliament')]")));
			//Start video(SWD)
			driver.findElement(By.xpath(
					"//*[contains(text(),'at European Parliament')]")).click();
			//Skip add if exists(SikuliX)
			Thread.sleep(10000);
			Screen s=new Screen();
			if(s.exists("skipadd.png")!=null)
			{
				s.click("skipadd.png");
			}
			//Pause video(SikukliX)
			s.mouseMove(200,200);//move mouse pointer to video body
			s.click("pause.png");
			//Play video(SikukliX)
			Thread.sleep(5000);
			s.mouseMove(200,200);//move mouse pointer to video body
			s.click("play.png");
			Thread.sleep(5000);
			//Close site(SWD)
			driver.close();
		}
	}
}




