package tests;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.zeroturnaround.zip.ZipUtil;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.ATUTestRecorder;
import io.appium.java_client.android.AndroidDriver;

public class Test7
{
	public static void main(String[] args) throws Exception
	{
		//Create a folder for results
		File fo=new File("E:\\calcapptestresults");
		fo.mkdir(); //if exists, it can append(can not overwrite)
		//Create html results file in that folder with appending
		ExtentReports er=new ExtentReports(
				fo.getAbsolutePath()+"\\calcappres.html",false); //false means append
		ExtentTest et=er.startTest("Calc App addition testing");
		//Create a new video file in that folder
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
		Date dt=new Date();
		ATUTestRecorder rec=new ATUTestRecorder(
				fo.getAbsolutePath(),"Videoon"+sf.format(dt),false);//false means no audio
		//start recording
		rec.start();
		//Take data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input1");
		String x=sc.nextLine();
		System.out.println("Enter input2");
		String y=sc.nextLine();
		//Start appium sever
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Define desired capabilities related to device and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
	    dc.setCapability("deviceName","emulator-5554");
	    dc.setCapability("platformName","android");
	    dc.setCapability("platformVersion","8.1.0");
		dc.setCapability("appPackage","com.android.calculator2");
	    dc.setCapability("appActivity","com.android.calculator2.Calculator");
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
			for(int i=0;i<x.length();i++)
			{
				char c=x.charAt(i);
				if(c=='-')
				{
					driver.findElement(By.xpath("//*[@content-desc='minus']")).click();
				}
				else
				{
					driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
				}
			}
			driver.findElement(By.xpath("//*[@content-desc='plus']")).click();

			for(int i=0;i<y.length();i++)
			{
				char c=y.charAt(i);
				if(c=='-')
				{
					driver.findElement(By.xpath("//*[@content-desc='minus']")).click();
				}
				else
				{
					driver.findElement(By.xpath("//*[@text='"+c+"']")).click();
				}
			}
			driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
			Thread.sleep(5000);
			String r=driver.findElement(By.xpath("//*[contains(@resource-id,'result')]")).getText();
			r=r.replace(",",""); //remove "," in result
			System.out.println(r);
			int i1=Integer.parseInt(x);
			int i2=Integer.parseInt(y);
			int o=Integer.parseInt(r);
			if(o==i1+i2)
			{
				et.log(LogStatus.PASS,"Test passed");
			}
			else
			{
				File src=driver.getScreenshotAs(OutputType.FILE);
				String fname=fo.getAbsolutePath()+sf.format(dt)+".png";
				File dest=new File(fname);
				FileHandler.copy(src, dest);
				et.log(LogStatus.FAIL,et.addScreenCapture(fname)+" Test failed");
			}
		}
		catch(Exception ex)
		{
			et.log(LogStatus.ERROR,ex.getMessage());
		}
		//Close app
		driver.closeApp();
		Thread.sleep(5000);
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe"); 
		//Close and save html results
		er.endTest(et);
		er.flush(); //save
		//Stop recording
		rec.stop();
		//Zip that folder
		File zipf=new File("E:\\calcapptestresultszip.zip");
		ZipUtil.pack(fo,zipf);
	}
}







