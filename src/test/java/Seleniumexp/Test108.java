package Seleniumexp;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test108 extends Thread
{
	public void run()
	{
		try
		{
		//Automate basic authentication window(Java Robot)
		Thread.sleep(10000);
		StringSelection x=new StringSelection("admin"); //userid
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		StringSelection y=new StringSelection("admin"); //password
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y,null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception ex)
		{
			System.out.println("Sorry, i am not able to handle pop-up");
		}
	}
	public static void main(String[] args) throws Exception
	{
		Test108 obj=new Test108();
		obj.start();
		//Open chrome browser
		System.setProperty("webdriver.chrome.driver","E:\\batch246\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site using original URL
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		//Goto further automation on pages
	}
}
