package Seleniumexp;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Test87
{
	public static void main(String[] args)
	{
		//Set value to a preference to stop notifications
		FirefoxOptions fo=new FirefoxOptions();
		fo.addPreference("dom.webnotifications.enabled",false);
		//Open firefox browser
		System.setProperty("webdriver.gecko.driver","E:\\batch246\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"E:\\geckologs.txt");
		FirefoxDriver driver=new FirefoxDriver(fo);
		driver.manage().window().maximize();
		//Launch site and wait until text box is visible in page
		driver.get("https://www.redbus.in");
	}
}




