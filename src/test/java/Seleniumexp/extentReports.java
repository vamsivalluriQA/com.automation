package Seleniumexp;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extentReports
{
	public static void main(String[] args) throws Exception
	{
		//Register a html file for results
		ExtentReports er=new ExtentReports("amazonresults.html",false);
		ExtentTest et=er.startTest("Amazon home page testing");
		//Open browser and launch site
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
		//get title and test(test case-1)
		String x=driver.getTitle();
		if(x.contains("Shoping"))
		{
			et.log(LogStatus.PASS, "Title test passed");
		}
		else
		{
			//Take screenshot
			File src=driver.getScreenshotAs(OutputType.FILE);
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
			Date dt=new Date();
			String fname=sf.format(dt)+".png";
			File dest=new File(fname);
			FileHandler.copy(src, dest);
			et.log(LogStatus.FAIL,et.addScreenCapture(fname)+" title is wrong");
		}
		//Get current url and test(test case-2)
		String y=driver.getCurrentUrl();
		if(y.contains("htps"))
		{
			et.log(LogStatus.PASS, "secured site test passed");
		}
		else
		{
			//Take screenshot
			File src=driver.getScreenshotAs(OutputType.FILE);
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
			Date dt=new Date();
			String fname=sf.format(dt)+".png";
			File dest=new File(fname);
			FileHandler.copy(src, dest);
			et.log(LogStatus.FAIL,et.addScreenCapture(fname)+" no security");
		}
		//Close site
		driver.close();
		//save and close html file
		er.endTest(et);
		er.flush(); //save
		er.close();
	}
}
