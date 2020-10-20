package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test66
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://jqueryui.com/slider");
		Thread.sleep(5000);
		//Horizontal slider
		driver.switchTo().frame(0); //switch to frame
		WebElement e1=driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions a=new Actions(driver);
		//left to right
		a.dragAndDropBy(e1,400,0).perform();
		Thread.sleep(5000);
		//right to left
		a.dragAndDropBy(e1,-400,0).perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent(); //back to page
		//Vertical slider
		driver.findElement(By.linkText("Vertical slider")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(0); //switch to frame
		WebElement e2=driver.findElement(By.xpath("//*[@id='slider-vertical']/span"));
		//top to bottom
		a.dragAndDropBy(e2,0,100).perform();
		Thread.sleep(5000);
		//bottom to top
		a.dragAndDropBy(e2,0,-200).perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
	}
}











