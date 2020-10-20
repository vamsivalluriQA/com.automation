package Seleniumexp;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test85 
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a name");
		String x=sc.nextLine();
		//Open firefox browser and Launch site
		System.setProperty("webdriver.gecko.driver","E:\\batch247\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"E:\\geckologs.txt");
		FirefoxDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://angularjs.org");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@ng-model='yourName']")));
		//Enter text
		driver.findElement(By.xpath("//*[@ng-model='yourName']")).sendKeys(x); //input element
		WebElement e=null;
		try
		{
			//locate output element with dynamically changing text
			e=driver.findElement(By.xpath("//h1[text()='Hello "+x+"!']")); //output element
			w.until(ExpectedConditions.visibilityOf(e)); 
			System.out.println("Test passed");
		}
		catch(Exception ex)
		{
			System.out.println("Test failed due to "+ex.getMessage());
			//highlight element
			driver.executeScript("arguments[0].style.border='dotted 5px red';",e);
			//take screenshot of page and save with current date and time
			SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
			Date dt=new Date();
			String ssname=sf.format(dt)+".png";
			File pagesrc=driver.getScreenshotAs(OutputType.FILE);
			File pagedest=new File(ssname);
			FileHandler.copy(pagesrc,pagedest);
		}
		//Close site
		driver.close();

	}

}
