package Seleniumexp;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test88
{
	public static void main(String[] args) throws Exception
	{
		//Create an empty folder
		File fo=new File("E:\\mydownloads247");
		fo.mkdir(); 
		//Store preferences/arguments with values as pairs in a hash map
		HashMap<String,Object> hm=new HashMap<String,Object>();
		hm.put("profile.default_content_settings.popups",0); //0 means off
		hm.put("download.default_directory",fo.getAbsolutePath());
		//search for chrome preference to give MIME type for file to be downloaded
		//Set hash map pairs to chrome browser preferences
		ChromeOptions co=new ChromeOptions();
		co.setExperimentalOption("prefs",hm); //"prefs" is fixed word
		//Open browser with given preferences
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://selenium.dev/");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='DOWNLOAD'])[3]")));
		driver.findElement(By.xpath("(//*[text()='DOWNLOAD'])[3]")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.linkText("3.141.59")));
		driver.findElement(By.linkText("3.141.59")).click();
		Thread.sleep(10000); //should be required for complete downloading
		//Close site
		//driver.close();
	}
}







