package Seleniumexp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test26
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
		//Collect all elements in home page
		List<WebElement> l1=driver.findElements(By.xpath("//*"));
		System.out.println("count of all elements is "+l1.size());
		//Collect all images
		List<WebElement> l2=driver.findElements(By.xpath("//img"));
		System.out.println("count of all images is "+l2.size());
		int vic=0;
		int hic=0;
		for(WebElement e:l2) //for each loop
		{
			if(e.isDisplayed())
			{
				vic=vic+1;
			}
			else
			{
				hic=hic+1;
			}
		}
		System.out.println("count of visible images is "+vic);
		System.out.println("count of hidden images is "+hic);
		//Close site
		driver.close();
	}
}






