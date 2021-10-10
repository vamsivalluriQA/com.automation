package tests;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Test8
{
	public static void main(String[] args) throws Exception
	{
		//Get phone number from keyboad
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone number to dial");
		String phonenum=sc.nextLine();
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and app
		DesiredCapabilities dc=new DesiredCapabilities();
	    dc.setCapability("deviceName","emulator-5554");
	    dc.setCapability("platformName","android");
	    dc.setCapability("platformVersion","8.1.0");
		dc.setCapability("appPackage","com.google.android.dialer");
	    dc.setCapability("appActivity","com.google.android.dialer.extensions.GoogleDialtactsActivity");
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
		//Test automation
		try
		{
			try
			{
				driver.findElement(By.xpath("//*[@content-desc='key pad']")).click();
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//*[@text='Add call']")).click();
			}
			Thread.sleep(5000);
			for(int i=0;i<phonenum.length();i++)
			{
				char d=phonenum.charAt(i);
				driver.findElement(By.xpath("//*[contains(@content-desc,'"+d+"')]")).click();
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@content-desc='dial']")).click();
			Thread.sleep(5000);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Close app
		driver.closeApp();
		Thread.sleep(5000);
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe"); 
	}
}







