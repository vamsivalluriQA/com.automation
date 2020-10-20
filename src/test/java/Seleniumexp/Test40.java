package Seleniumexp;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test40
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Click on "Gmail" link
		driver.findElement(By.linkText("Gmail")).click();
		Thread.sleep(5000);
		//Click on "Sign In" link
		driver.findElement(By.partialLinkText("Sign in")).click();
		Thread.sleep(5000);
		//Collect all browser window/tab handles
		Set<String> s=driver.getWindowHandles();
		ArrayList<String> l=new ArrayList<String>(s);
		//Use those handles to change focus of driver object from one to other window/tab
		driver.switchTo().window(l.get(1)); //2nd browser window/tab
		driver.findElement(By.name("identifier")).sendKeys("seleniumfullstack");
		Thread.sleep(5000);
		driver.switchTo().window(l.get(0)); //1st browser window/tab
		driver.findElement(By.partialLinkText("Sign in")).click();
		Thread.sleep(5000);
		//Collect all browser window/tab handles
		s=driver.getWindowHandles();
		l=new ArrayList<String>(s);
		driver.switchTo().window(l.get(2)); //3rd browser window/tab
		driver.findElement(By.name("identifier")).sendKeys("seleniumhalfstack");
		driver.switchTo().window(l.get(0)); //Back to 1st browser window/tab
		//Close all browser windows or tabs
		driver.quit();
	}
}
