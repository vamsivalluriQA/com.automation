package Seleniumexp;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test89
{
	public static void main(String[] args) throws Exception
	{
		//Create an empty folder
		File fo=new File("E:\\mydownloads247");
		fo.mkdir(); 
		//Define preferences for firefox browser
		FirefoxProfile profile=new FirefoxProfile();
		//Set a folder path to save file to be download
		profile.setPreference("browser.download.dir",fo.getAbsolutePath());
		//1 means downloads folder, 2 means given folder
		profile.setPreference("browser.download.folderList",2); 
		//Stop pop-up windows which are indicate file download 
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		profile.setPreference("pdfjs.disabled",true);
		//Set MIME type w.r.t type of file to be download(ex: jar file) 
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				     "application/java-archive application/x-java-archive application/x-jar");
		FirefoxOptions ffo=new FirefoxOptions();
		ffo.setProfile(profile);
		//Open browser
		System.setProperty("webdriver.gecko.driver","E:\\batch247\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver(ffo);
		//Launch site
		driver.get("https://selenium.dev/");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='DOWNLOAD'])[3]")));
		driver.findElement(By.xpath("(//*[text()='DOWNLOAD'])[3]")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.linkText("3.141.59")));
		driver.findElement(By.linkText("3.141.59")).click();
		Thread.sleep(10000); //should be required for complete downloading
		//Close site
		driver.close();
	}
}
