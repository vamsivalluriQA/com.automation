package Seleniumexp;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test28 
{
	public static void main(String[] args) throws Exception
	{
		//Get a word to be searched from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x=sc.nextLine();
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//search given word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER); //Parameterization
		Thread.sleep(5000);
		//Pagination
		int allrescount=0;
		int pagenumber=0;
		while(2>1) //infinite loop
		{
			pagenumber++;
			int rescountperpage=0;
			//Collect all results in current page
			List<WebElement> l=driver.findElements(By.xpath("//div[@class='rc']"));
			for(WebElement e:l) //for each result in all collected results in current page
			{
				if(e.isDisplayed())
				{
					rescountperpage++;
				}
			}
			//Display current page results
			System.out.println(pagenumber+" page had "+rescountperpage+" results");
			allrescount=allrescount+rescountperpage;
			//Go to next page
			try
			{
				driver.findElement(By.xpath("//*[text()='Next']")).click();
				Thread.sleep(2000);
			}
			catch(Exception ex)
			{
				break; //terminate from infinite loop
			}
		}
		//Display final output
		System.out.println("Total results count is "+allrescount);
		//Close site
		driver.close();
	}
}












