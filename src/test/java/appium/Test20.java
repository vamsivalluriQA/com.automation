package tests;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test20 
{
	public static void main(String[] args) throws Exception
	{
		//Get environment
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter environment");
		String en=sc.nextLine();
		RemoteWebDriver driver; //common concrete class related to SWD and AJC jars classes
		//Specific code as per environment
		if(en.equalsIgnoreCase("mobile"))
		{
			//Start appium sever to use given "chromedriver" as per version of "chrome" in device
			Runtime.getRuntime().exec(
               "cmd.exe /c start cmd.exe /k \"appium --chromedriver-executable E:\\batch249\\chromedriver.exe\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Define desired capabilities related to android device and browser
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,"chrome");
			dc.setCapability("deviceName","xxxxxxx");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","xx");
			//Launch browser in device through appium server by creating driver object
	    	while(2>1)
	    	{
	    		try
	    		{
	    			driver=new AndroidDriver(u,dc);
	    			break; //terminate from current loop
	    		}
	    		catch(Exception ex)
	    		{
	    		}
	    	} 
		}
		else
		{
			System.out.println("Enter browser name");
			String bn=sc.nextLine();
			//Launch browser in computer by creating driver object
			if(bn.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(); 
			}
			else if(bn.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver(); 
			}
			else if(bn.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver(); 
			}
			else if(bn.equalsIgnoreCase("opera"))
			{
				WebDriverManager.operadriver().setup();
				driver=new OperaDriver(); //definition of object
			}
			else             
			{
				WebDriverManager.iedriver().setup();  //put zoom level 100% for "ie" browser
				driver=new InternetExplorerDriver(); 
			}
			driver.manage().window().maximize();
			Thread.sleep(5000);
		}
		//Common code for both environments(site in mobile & site in computer)
		//use xpath(), cssSeector(), tagName(), className(), id(), linkText() & partialLinkText().
		try
		{
			Thread.sleep(10000);
			//Launch site
			driver.get("http://newtours.demoaut.com");
			Thread.sleep(5000);
			//click register link
			//driver.findElement(By.partialLinkText("REGISTER")).click();
			driver.findElementByPartialLinkText("REGISTER").click();
			Thread.sleep(5000);
			//Fill fields
			driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("abdul");
			driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("kalam");
			driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("9000564534");
			driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("apj@abdulkalam.com");
			driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("dno-11,mosque street");
			driver.findElement(By.cssSelector("input[name='address2']")).sendKeys("dhanushkoti road");
			driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Rameshwaram");
			driver.findElementByCssSelector("input[name='state']").sendKeys("Tamilnadu");
			driver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys("645782");
			Thread.sleep(5000);
			//automate drop-down
			//WebElement e=driver.findElement(By.tagName("select"));
			WebElement e=driver.findElementByTagName("select");
			Select s=new Select(e);
			s.selectByVisibleText("INDIA");
			Thread.sleep(5000);
			//Fill remaining fields
			driver.findElement(By.cssSelector("input[name='email']")).sendKeys("apj11");
			driver.findElement(By.cssSelector("input[name='password']")).sendKeys("batch249");
			driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("batch249");
			Thread.sleep(5000);
			//submit data to server
			driver.findElement(By.cssSelector("input[name='register']")).click();
			Thread.sleep(5000);
			//Close site
			driver.close();
		}
		catch(Exception ex)
		{
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yy-hh-mm-ss");
			Date dt=new Date();
			File src=driver.getScreenshotAs(OutputType.FILE);
			String fname=sf.format(dt)+".png";
			File dest=new File(fname);
			FileHandler.copy(src, dest);
			System.out.println(ex.getMessage());
		}
		//specific code as per mobile environment
		if(en.equalsIgnoreCase("mobile"))
		{
			//Stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
	}
}
