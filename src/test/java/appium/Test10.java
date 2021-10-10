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
import io.appium.java_client.android.AndroidDriver;

public class Test10
{
	public static void main(String[] args) throws Exception
	{
		//Create a new folder for test results
		File fo=new File("E:\\ardphoneappresults");
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
	    dc.setCapability("deviceName","RZ8M70HG1QK");
	    dc.setCapability("platformName","android");
	    dc.setCapability("platformVersion","10");
		dc.setCapability("appPackage","com.samsung.android.dialer");
	    dc.setCapability("appActivity","com.samsung.android.dialer.DialtactsActivity");
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
			Thread.sleep(5000);
			for(int i=0;i<phonenum.length();i++)
			{
				char d=phonenum.charAt(i);
				driver.findElement(By.xpath("//*[@content-desc='"+d+"']")).click();
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[contains(@resource-id,'dialButtonImage1')]")).click();
			Thread.sleep(10000); //fixed wait
			if(driver.findElement(By.xpath("//*[@text='Mute']")).isEnabled())
			{
				driver.findElement(By.xpath("//*[@content-desc='End call']")).click();
				Thread.sleep(5000);
				String msg=driver.findElement(By.xpath("//*[contains(@resource-id,'body_text_view')]")).getText();
				System.out.println(msg);
				driver.findElement(By.xpath("//*[@text='Cancel']")).click();
			}
			else
			{
				System.out.println("Not lifted or no balence or invalid number or network busy");
				driver.findElement(By.xpath("//*[@content-desc='End call']")).click();
			}
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
		File zipf=new File("E:\\ardphoneapptestresults.zip");
		ZipUtil.pack(fo,zipf);
	}
}







