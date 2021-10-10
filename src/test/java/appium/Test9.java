package tests;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.zeroturnaround.zip.ZipUtil;

import atu.testrecorder.ATUTestRecorder;
import io.appium.java_client.MobileSelector;
import io.appium.java_client.android.AndroidDriver;

public class Test9
{
	public static void main(String[] args) throws Exception
	{
		//Create a new folder for results
		File fo=new File("E:\\avdphoneappresults");
		fo.mkdir(); //if folder already exists, results can append
		//Create object to record a video
		SimpleDateFormat sf=new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date dt=new Date();
		ATUTestRecorder rec=new ATUTestRecorder(
				        fo.getAbsolutePath(),"Videoon"+sf.format(dt),false);
		rec.start();  
		//Get phone number from keyboad
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter phone number to dial");
		String phonenum=sc.nextLine();
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
	    dc.setCapability("deviceName","emulator-5554");
	    dc.setCapability("platformName","android");
	    dc.setCapability("platformVersion","8.1.0");
		dc.setCapability("appPackage","com.google.android.dialer");
	    dc.setCapability("appActivity","com.google.android.dialer.extensions.GoogleDialtactsActivity");
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
			//driver.findElement(By.xpath("//*[@content-desc='dial']")).click();
			driver.findElement(MobileSelector.ACCESSIBILITY.toString(),"dial");
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
		//Stop recorder
		rec.stop();
		//create zip file to results folder
		File zipf=new File("E:\\avdphoneapptestresults.zip");
		ZipUtil.pack(fo,zipf);
	}
}







