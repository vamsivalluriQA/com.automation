package Seleniumexp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test70
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Collect invisible items of a drop-down
		List<WebElement> l=driver.findElements(By.xpath(
				     "//h4[text()='Search Selection']/following-sibling::div/div[2]/div"));
		for(WebElement e:l)
		{
			//get text of each invisible item of drop-down using JavaScript
			String x=(String) driver.executeScript("return(arguments[0].textContent);",e);
			System.out.println(x);
		}
		//Close site
		driver.close();
	}
}





