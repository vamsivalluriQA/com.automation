package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test22 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//locate hidden element, which have HTML attributes,CSS properties & text 
		WebElement e=driver.findElement(By.xpath("(//*[text()='New'])[1]"));
		String x=e.getAttribute("class");
		String y=e.getCssValue("color");
		String z=e.getText();
		System.out.println(x); //value
		System.out.println(y); //value
		System.out.println(z); //blank because element has text but hidden in page
		String w=(String) driver.executeScript("return(arguments[0].textContent);",e);
		System.out.println(w);
		driver.close();
	}
}







