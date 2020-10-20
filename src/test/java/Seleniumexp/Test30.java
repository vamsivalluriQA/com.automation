package Seleniumexp;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Test30
{
	public static void main(String[] args) throws Exception
	{
		//Get a word to be searched from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter userid");
		String u=sc.nextLine();
		System.out.println("Enter password");
		String p=sc.nextLine();
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier")).sendKeys(u);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys(p);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		//Pagination
		int expectedunreadmailscount=0;
		while(2>1) //infinite loop
		{
			//Collect all mails in current page
			List<WebElement> mails=driver.findElements(By.xpath(
					                                "(//table[@role='grid'])[2]/tbody/tr"));
			//goto each mail and check for unread
			for(WebElement mail:mails)
			{
				WebElement e=mail.findElement(By.xpath("child::td[5]/div[1]"));
				String temp1=(String) driver.executeScript(
						                            "return(arguments[0].textContent);",e);
				if(temp1.contains("unread"))
				{
					expectedunreadmailscount++;
				}
			}
			//goto next page
			WebElement e=driver.findElement(By.xpath("//*[@data-tooltip='Older']"));
			try
			{
				if(e.getAttribute("aria-disabled").equals("true"))
				{
					break; //terminate from loop
				}
			}
			catch(Exception ex)
			{
				e.click(); //to goto next page
				Thread.sleep(2000);
			}
		}
		//Display output
		System.out.println("Total unread mails count is "+expectedunreadmailscount);
		//Get actual count given by site
		String temp2=driver.findElement(By.xpath("//a[text()='Inbox']/following::div[1]"))
				                                                                 .getText();
		int actualunreadmailscount=Integer.parseInt(temp2);
		//Validation
		if(actualunreadmailscount==expectedunreadmailscount)
		{
			System.out.println("Unread mails count Test passed");
		}
		else
		{
			System.out.println("Unread mails count Test failed");
			//took actual count screen shot
			File src=driver.findElement(By.xpath("//a[text()='Inbox']/following::div[1]"))
					                                    .getScreenshotAs(OutputType.FILE);
			File dest=new File("sreenshot.png");
			FileHandler.copy(src, dest);
		}
		//Do logout
		driver.findElement(By.xpath(
				"//a[starts-with(@aria-label,'Google Account')]/child::span")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//close site
		driver.close();
	}

}





