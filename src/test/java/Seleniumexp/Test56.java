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

public class Test56
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Close banner
		driver.findElement(By.xpath("//button[@aria-label='Close']/span")).click();
		Thread.sleep(5000);
		//Locate a drop-down(developed using <select> tag in HTML by developers)
		WebElement e=driver.findElement(By.name("nights"));
		Select s=new Select(e);
		List<WebElement> items=s.getOptions();
		int noi=items.size();
		System.out.println("Count of items is: "+noi);
		//Check items, which are in sorted order
		ArrayList<String> array1=new ArrayList<String>();
		ArrayList<String> array2=new ArrayList<String>();
		//Copy all items text into two arrays
		//Skip 1st item(index=0) because it is heading
		for(int i=1;i<noi;i++)
		{
			array1.add(items.get(i).getText());
			array2.add(items.get(i).getText());
		}
		//Sort 2nd array
		Collections.sort(array2);
		//Display both arrays
		for(int i=0;i<array1.size();i++)
		{
			System.out.println(array1.get(i)+"--------"+array2.get(i));
		}
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
			e.click();
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
