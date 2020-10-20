package Seleniumexp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test61
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
		s.equals(s);
		s.hashCode();
		//select items in multi-select drop down
		Actions a=new Actions(driver);
		a.keyDown(Keys.CONTROL)
		 .click(s.getOptions().get(3))
		 .click(s.getOptions().get(0))
		 .click(s.getOptions().get(2))
		 .keyUp(Keys.CONTROL)
		 .build().perform();
		Thread.sleep(5000);
		//Get 1st item in selected list
		String x=s.getFirstSelectedOption().getText();
		System.out.println("1st item in selected list is "+x);
		//Get and display selected items
		List<WebElement> selected=s.getAllSelectedOptions();
		System.out.println("count of selected items is "+selected.size());
		for(WebElement item:selected)
		{
			System.out.println(item.getText());
		}
		//Close site
		driver.close();
	}
}
