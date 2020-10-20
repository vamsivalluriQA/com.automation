package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test38 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Switch to frame using name of that frame
		driver.switchTo().frame("iframeResult");
		//Click on a button
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(5000);
		//Switch to alert
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		driver.switchTo().alert().dismiss();
		//Back to page
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}






