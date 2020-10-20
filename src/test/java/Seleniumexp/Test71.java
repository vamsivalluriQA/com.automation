package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test71
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//locate element and change source of that element
		WebElement e=driver.findElement(By.name("q"));
		//change-1: background color
		driver.executeScript("arguments[0].style.background='green';",e); 
		Thread.sleep(5000);
		//change-2: Disable element
		driver.executeScript("arguments[0].disabled=true;",e);
		Thread.sleep(5000);
		//change-3: back to enable
		driver.executeScript("arguments[0].disabled=false;",e);
		Thread.sleep(5000);
		//change-4: enter text in red color
		driver.executeScript("arguments[0].style.color='red';",e);
		driver.executeScript("arguments[0].value='abdul kalam';",e);
		Thread.sleep(5000);
		//change-5: highlight that element
		driver.executeScript("arguments[0].style.border='5px blue solid';",e);
		Thread.sleep(5000);
		//refresh page to remove all changes
		driver.navigate().refresh();
	}
}





