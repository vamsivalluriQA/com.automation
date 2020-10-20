package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.locators.RelativeLocator;

public class Test16 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Locate element via visual relations with other elements in page
		WebElement e1=driver.findElement(By.xpath("//*[text()='Continue to Gmail']"));
		WebElement e2=driver.findElement(By.xpath("//*[text()='Forgot email?']"));
		//WebElement e3=driver.findElement(RelativeLocator.withTagName("input").below(e1).above(e2));
		//e3.sendKeys("kalamsir");
		WebElement e4=driver.findElement(By.xpath("//*[text()='Create account']"));
		//WebElement e5=driver.findElement(RelativeLocator.withTagName("span").near(e4).xpath("//*[text()='Next']"));
		//e5.click();
	}
}





