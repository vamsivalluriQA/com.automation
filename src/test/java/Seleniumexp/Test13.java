package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test13 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("seleniumfullstack");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Sdet1234");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		Thread.sleep(5000);
		//Click on Compose 
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		Thread.sleep(5000);
		//Fill fields in compose screen and click on Send
		driver.findElement(By.name("to")).sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("subjectbox")).sendKeys("wishes");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(
				"Hi sir,\nHow are you in haven?\nThanking you sir\n Bye");
		driver.findElement(By.xpath("//*[starts-with(@aria-label,'Send')][@role='button']"))
		                                                                           .click();
		Thread.sleep(5000);
		String m=driver.findElement(By.xpath("(//div[@class='vh'])[1]/span[1]")).getText();
		System.out.println(m);
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








