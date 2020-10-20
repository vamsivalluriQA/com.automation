package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test60
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		Thread.sleep(5000);
		//Locate drop down(<select> tag drop down)
		driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.name("cars"));
		Select s=new Select(e);
		//select items in multi-select drop down
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL)
		 .click(s.getOptions().get(3))
		 .click(s.getOptions().get(0))
		 .click(s.getOptions().get(2))
		 .keyUp(Keys.CONTROL)
		 .build().perform();
		Thread.sleep(5000);
		//deselect selected items
		//s.deselectAll();
		//s.deselectByIndex(3); //3 is index of Audi
		//s.deselectByVisibleText("Audi");
		s.deselectByValue("audi"); //audi is value of Audi
	}
}








