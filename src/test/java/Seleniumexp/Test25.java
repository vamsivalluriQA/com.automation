package Seleniumexp;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test25
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		//Locate radio button
		WebElement e1=driver.findElement(By.xpath(
				              "(//label[text()='One Way'])[1]/preceding-sibling::*"));
		if(e1.isSelected())
		{
			System.out.println("Radio button is in ON");
		}
		else
		{
			System.out.println("Radio button is in OFF");
			File src=e1.getScreenshotAs(OutputType.FILE);
			File dest=new File("E:\\batch247\\elescreenshot1.png");
			FileHandler.copy(src,dest);
		}
		//Locate check-box
		WebElement e2=driver.findElement(By.xpath(
				          "//label[contains(text(),'Family')]/preceding-sibling::*[1]"));
		if(e2.isSelected())
		{
			System.out.println("Check box is in ON");
		}
		else
		{
			System.out.println("Check box is in OFF");
			File src=e2.getScreenshotAs(OutputType.FILE);
			File dest=new File("E:\\batch247\\elescreenshot2.png");
			FileHandler.copy(src,dest);
		}
		//Locate drop-down
		WebElement e3=driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT"));
		if(e3.isSelected())
		{
			System.out.println("Default Item selected in Drop-down");
		}
		else
		{
			System.out.println("Item was not selected in Drop-down");
			File src=e3.getScreenshotAs(OutputType.FILE);
			File dest=new File("E:\\batch247\\elescreenshot3.png");
			FileHandler.copy(src,dest);
		}
		//Close site
		driver.close();
	}
}






