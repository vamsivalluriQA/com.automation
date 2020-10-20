package Seleniumexp;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Test55
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(5000);
		//Click on register link
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(5000);
		//Locate drop-down which is developed using <select> tag
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		//Collect all items from that drop-down as elements
		List<WebElement> items=s.getOptions();
		int noi=items.size();
		System.out.println("Count of items is: "+noi);
		//Check items, which are in sorted order
		ArrayList<String> array1=new ArrayList<String>();
		ArrayList<String> array2=new ArrayList<String>();
		//Copy all items text into two arrays
		for(WebElement item:items)
		{
			array1.add(item.getText());
			array2.add(item.getText());
		}
		//Sort 2nd array
		Collections.sort(array2);
		//Compare array1 and array2
		int flag=0;
		for(int i=0;i<array1.size();i++)
		{
			if(!array1.get(i).equals(array2.get(i)))
			{
				flag=1;
				break; //terminate from loop
			}
		}
		if(flag==0)
		{
			System.out.println("Items in sorted order");
		}
		else
		{
			System.out.println("Items are not in sorted order");
			//click on drop-down to get visibility of items
			s.getWrappedElement().click();
			Thread.sleep(5000);
			//get page screenshot
			File pagesrc=driver.getScreenshotAs(OutputType.FILE);
			File pagedest=new File("dropdownitems.png");
			FileHandler.copy(pagesrc, pagedest);
		}
		//close site
		driver.close();

	}
}
