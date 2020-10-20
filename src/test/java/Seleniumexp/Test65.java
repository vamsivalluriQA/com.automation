package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test65
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://jqueryui.com/droppable");
		Thread.sleep(5000);
		//Drag and Drop
		driver.switchTo().frame(0);
		WebElement e1=driver.findElement(By.id("draggable"));
		driver.executeScript("arguments[0].scrollIntoView();",e1);
		Thread.sleep(5000);
		WebElement e2=driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
		a.dragAndDrop(e1,e2).perform();
		driver.switchTo().defaultContent();
		
		

	}
}











