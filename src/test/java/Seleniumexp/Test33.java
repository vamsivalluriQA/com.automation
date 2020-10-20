package Seleniumexp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test33
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Locate a <div> tag drop down and get it into visible area of desktop
		WebElement dd=driver.findElement(By.xpath(
				                  "//a[@id='multiple-selection']/following-sibling::div"));
		WebElement neighbour=driver.findElement(By.xpath(
				                                     "//h4[text()='Multiple Selection']"));
		driver.executeScript("arguments[0].scrollIntoView();",neighbour);
		Thread.sleep(5000);
		//Test case-1: check for multi-select or not
		if(dd.getAttribute("class").contains("multiple"))
		{
			System.out.println("Multi-select drop down");
			//Start Testing
			//Test case-2:collect all items of it and display those items text
			List<WebElement> items=dd.findElements(By.xpath("child::div[2]/div"));
			System.out.println("Count of items is "+items.size());
			System.out.println("Items are:");
			for(WebElement item:items)
			{
				//Get invisible items text via JavaScript
				String x=(String) driver.executeScript(
						                        "return(arguments[0].textContent);",item);
				System.out.println(x);
			}
			//Test case-3:Select each item, test that selection and deselect that item
			for(WebElement item:items)
			{
				try
				{
					//1. Open drop down
					dd.click();
					Thread.sleep(2000);
					//2.Check for item visibility
					if(item.isDisplayed())
					{
						//3.Remember text of item to be selected
						String expected=item.getText();
						//4.select that item
						item.click();
						Thread.sleep(2000);
						//5.get selected item text
						String actual=dd.findElement(By.xpath("child::a")).getText();
						//6.compare both remembered text and visible text of selected item
						if(expected.equals(actual))
						{
							System.out.println(expected+" item selection test passed");
						}
						else
						{
							System.out.println(expected+" item selection test failed");
						}
						//7.de-select that item
						dd.findElement(By.xpath("child::a/i")).click();
						Thread.sleep(2000);
					}
					else
					{
						String y=(String) driver.executeScript(
								                  "return arguments[0].textContent;",item);
						System.out.println(y+" Item is hidden");
					}
					//8. close drop down
					dd.sendKeys(Keys.ESCAPE);
					Thread.sleep(2000);
				}
				catch(Exception ex1)
				{
					System.out.println(ex1.getMessage());
				}
			} //loop ending
			//Test case-4: Select multiple items and test them
			//1.Open drop down
			dd.click();
			Thread.sleep(2000);
			//2. looping on items
			int flag=0;
			for(int i=0;i<items.size();i++)
			{
				try
				{
					//3.Remember text of item to be selected
					String expected=items.get(i).getText();
					//4.select that item
					items.get(i).click();
					Thread.sleep(2000);
					//5.get selected item text
					String actual=dd.findElement(By.xpath("child::a["+(i+1)+"]")).getText();
					//6.compare remembered text and visible text of selected item
					if(!expected.equals(actual))
					{
						flag=1;
					}
				}
				catch(Exception ex)
				{
					flag=1;
				}
			} //loop ending
			//7. check flag after selecting all items
			if(flag==0)
			{
				System.out.println("Multiple items selection is correct");
			}
			else
			{
				System.out.println("Multiple items selection is incorrect");
			}
		} //if ending related to multi-select drop down
		else
		{
			System.out.println("Single-select drop down");
		}
		//Close site
		driver.close();
	}
}
