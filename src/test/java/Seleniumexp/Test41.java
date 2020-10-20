package Seleniumexp;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test41
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch Gmail site under testing
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Do login in Gmail
		driver.findElement(By.name("identifier")).sendKeys("xxxxxxxxxxx");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("xxxxxxxxxx");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		//Click on Compose in Gmail
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		Thread.sleep(5000);
		//Fill fields in compose screen and click on Send in Gmail
		driver.findElement(By.name("to")).sendKeys("xxxxxxxxx@yahoo.com");
		driver.findElement(By.name("subjectbox")).sendKeys("wishes");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(
						                           "Hi friend,\nHow are you in home?");
		driver.findElement(By.xpath("//*[starts-with(@aria-label,'Send')][@role='button']"))
		                                                                           .click();
		Thread.sleep(5000);
		String m=driver.findElement(By.xpath("(//div[@class='vh'])[1]/span[1]")).getText();
		System.out.println(m);
		//Open new browser window/tab
		//driver.switchTo().newWindow(WindowType.WINDOW);
		//Collect all browser window/tab handles
		Set<String> s=driver.getWindowHandles();
		ArrayList<String> l=new ArrayList<String>(s);
		//Use those handles to change focus of driver object from one to other window/tab
		driver.switchTo().window(l.get(1)); //2nd browser window/tab
		//Launch Yahoo site(Supporting site)
		driver.get("http://www.yahoomail.com");
		Thread.sleep(5000);
		//Do login to yahoo
		driver.findElement(By.xpath("//*[text()='Sign in']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("xxxxxxxxxx");
		driver.findElement(By.name("signin")).submit();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("xxxxxxxx",Keys.ENTER);		
		Thread.sleep(5000);
		//Goto latest mail in mailbox 
		WebElement latestmail=driver.findElement(By.xpath(
				           "(//button[contains(@title,'Tickbox')])[2]/ancestor::li"));
		String fromaddress=latestmail.findElement(By.xpath("descendant::span[4]"))
				                                               .getAttribute("title");
		//Check "from" address, which is gmail userid
		if(fromaddress.contains("xxxxxxxxx"))
		{
			System.out.println("Gmail mail sent works correctly");
		}
		else
		{
			System.out.println("Gmail mail sent works not correct");
		}
		//Do logout in yahoo
		driver.findElement(By.xpath("//img[@role='presentation']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Sign out']")).click();
		Thread.sleep(5000);
		//close yahoo
		driver.close();
		Thread.sleep(5000);
		//back to Gmail
		driver.switchTo().window(l.get(0)); //1st browser window/tab
		//Do logout in Gmail
		driver.findElement(By.xpath(
				"//a[starts-with(@aria-label,'Google Account')]/span")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close Gmail
		driver.close();
	}
}








