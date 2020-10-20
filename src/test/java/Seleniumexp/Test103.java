package Seleniumexp;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test103
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		//Do login
		driver.findElement(By.name("identifier")).sendKeys("subramanyamtesting");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("suchindra249");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Compose']")));
		//Click on Compose 
		driver.findElement(By.xpath("//*[text()='Compose']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("to")));
		//Fill fields in compose screen
		driver.findElement(By.name("to")).sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("subjectbox")).sendKeys("wishes");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(
				                 "Hi sir,\nHow are you in haven?\nThanking you sir\n Bye");
		//Goto Attachment via click on attachment icon
		driver.findElement(By.xpath("//*[@data-tooltip='Attach files']/descendant::div[1]"))
		                                                                            .click();
		//Handle file upload window(Java Robot)
		Thread.sleep(5000); //wait for file upload pop-up window
		StringSelection f=new StringSelection(
				"C:\\Users\\Public\\Pictures\\Sample Pictures\\tulips.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(f,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		//send mail and get output to display
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
												"//*[contains(@aria-label,'Uploading')]")));
		driver.findElement(By.xpath("//*[starts-with(@aria-label,'Send')][@role='button']"))
																				.click();
		try
		{
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					                             "//*[contains(text(),'Message sent')]")));
			System.out.println("Test passed");
		}
		catch(Exception ex)
		{
			System.out.println("Test failed");
		}
		//Do logout
		driver.findElement(By.xpath(
				"//a[starts-with(@aria-label,'Google Account')]/child::span")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign out")));
		driver.findElement(By.linkText("Sign out")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				                                      "//*[text()='Choose an account']")));
		//close site
		driver.close();
	}
}
