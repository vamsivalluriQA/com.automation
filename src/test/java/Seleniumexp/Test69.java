package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test69
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//using JavaScript
		WebElement e=driver.findElement(By.name("q"));
		driver.executeScript("arguments[0].value='kalam';",e);
		driver.executeScript("arguments[0].style.border='2px red dashed';",e);
		
		

	}

}







