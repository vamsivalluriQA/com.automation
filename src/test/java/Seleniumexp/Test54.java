package Seleniumexp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test54
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Close banner
		driver.findElement(By.xpath("//button[@aria-label='Close']/span")).click();
		Thread.sleep(5000);
		//Locate a drop-down(developed using <select> tag in HTML by developers)
		WebElement e=driver.findElement(By.name("nights"));
		Select s=new Select(e);
		List<WebElement> items=s.getOptions();
		System.out.println("Count of items is "+items.size());
		for(WebElement item:items)
		{
			System.out.println(item.getText());
		}
		//Close site
		driver.close();
	}
}








