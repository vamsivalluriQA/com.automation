package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test67
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		Thread.sleep(5000);
		//Tool-tip is title attribute value for target element
		WebElement e1=driver.findElement(By.linkText("SQL"));
		String x=e1.getAttribute("title");
		System.out.println(x);
		//Tool-tip is child element to target element
		WebElement e2=driver.findElement(By.xpath("//div[contains(text(),'Top')]"));
		Actions a=new Actions(driver);
		a.moveToElement(e2).clickAndHold().build().perform();
		Thread.sleep(5000);
		WebElement tt=e2.findElement(By.xpath("child::span"));
		String y=tt.getText();
		System.out.println(y);
		a.release().perform();
		//close site
		driver.close();
	}
}




