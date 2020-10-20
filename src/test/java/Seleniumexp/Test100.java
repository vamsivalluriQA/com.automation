package Seleniumexp;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test100
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch246\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site and get latitude and longitude values of current location
		driver.get("https://the-internet.herokuapp.com/geolocation");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(
				               By.xpath("//button[text()='Where am I?']")));
		driver.findElement(By.xpath("//button[text()='Where am I?']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("lat-value")));
		String la1=driver.findElement(By.id("lat-value")).getText();
		String lo1=driver.findElement(By.id("long-value")).getText();
		System.out.println(la1+" "+lo1);
		Thread.sleep(5000);
		//Create DevTools session and set latitude and longitude values of desired location
		//DevTools dt=driver.getDevTools();
		//dt.createSession();
		HashMap<String, Object> params=new HashMap<String, Object>();
        params.put("latitude", 12.972442);
        params.put("longitude", 77.580643);
        params.put("accuracy", 1);
        //driver.executeCdpCommand("Emulation.setGeolocationOverride", params);
        //Get latitude and longitude values after change
        w.until(ExpectedConditions.elementToBeClickable(
	               By.xpath("//button[text()='Where am I?']")));
        driver.findElement(By.xpath("//button[text()='Where am I?']")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("lat-value")));
        String la2=driver.findElement(By.id("lat-value")).getText();
        String lo2=driver.findElement(By.id("long-value")).getText();
        System.out.println(la2+" "+lo2);
	}
}
