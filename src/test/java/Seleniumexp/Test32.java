package Seleniumexp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test32
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Locate <div> tag drop down and get it into visible area of desktop
		WebElement dd=driver.findElement(By.xpath(
				                          "//a[@id='selection']/following-sibling::*[3]"));
		WebElement neighbour=driver.findElement(By.xpath("//h4[text()='Selection']"));
		driver.executeScript("arguments[0].scrollIntoView();",neighbour);
		//Test case-1:Check for single-select or not
		if(dd.getAttribute("class").contains("multiple"))
		{
			System.out.println("Multi-select drop down");
			//stop testing
		}
		else
		{
			System.out.println("Single-select drop down");
			//Start Testing
			//Test case-2: Collect all items in that single select drop down and display
			List<WebElement> items=dd.findElements(By.xpath("child::div[2]/div"));
			System.out.println("Count of items in drop down is "+items.size());
			System.out.println("Items are:");
			for(WebElement item:items)
			{
				//Get invisible items text using JavaScript
				String x=(String) driver.executeScript(
						                           "return(arguments[0].textContent);",item);
				System.out.println(x);
			}
			//Test case-3: Select each item and test that selection
			for(WebElement item:items)
			{
				try
				{
					//1.Open drop down to get visibility of items
					dd.click();
					Thread.sleep(2000);
					//2. check item for visibility
					if(item.isDisplayed())
					{
						//3.Remember text of that item to be selected
						String expected=item.getText();
						//4.select that item
						item.click();
						Thread.sleep(2000);
						//5.get selected item text
						String actual=dd.findElement(By.xpath("child::div[1]")).getText();
						//6.compare both remembered text and visible text of selected item
						if(expected.equals(actual))
						{
							System.out.println(expected+" item selection test passed");
						}
						else
						{
							System.out.println(expected+" item selection test failed");
						}
					}
					else
					{
						String y=(String) driver.executeScript(
								                "return(arguments[0].textContent);",item);
						System.out.println(y+" Item is hidden");
					}
				}
				catch(Exception ex)
				{
					System.out.println(ex.getMessage());	
				}
			}//loop ending
		} //else ending
		//Close site
		driver.close();
	}
}










