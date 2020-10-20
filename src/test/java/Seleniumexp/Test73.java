package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test73
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser and launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//Change browser widow size
		Dimension d=new Dimension(400,500); //width and height
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Scroll down
		driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		//driver.executeScript("window.scrollBy(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		//Scroll up
		driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		//driver.executeScript("window.scrollBy(0,-(document.body.scrollHeight));");
		Thread.sleep(5000);
		//Scroll right
		driver.executeScript("window.scrollBy(document.body.scrollWidth,0);");
		Thread.sleep(5000);
		//Scroll left
		driver.executeScript("window.scrollBy(-(document.body.scrollWidth),0);");
		Thread.sleep(5000);
		//Scroll to specific element in page
		WebElement e=driver.findElement(By.name("q"));
		driver.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(5000);
		//Close site
		driver.close(); 
	}
}




