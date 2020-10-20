package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test59
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
		WebElement e=driver.findElement(By.name("theme"));
		Select s=new Select(e);
		s.selectByIndex(4); //5th item
		Thread.sleep(5000);
		s.selectByVisibleText("Family");
		Thread.sleep(5000);
		s.selectByValue("18");

	}
}





