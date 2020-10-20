package Seleniumexp;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;

public class Test51
{
	public static void main(String[] args) throws Exception
	{
		//open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get browser logs
		List<LogEntry> alllogs=driver.manage().logs().get("browser").getAll();
		for(LogEntry le:alllogs)
		{
			System.out.println(le.getMessage()+" "+le.getTimestamp());
		}
		//Close site
		driver.close();
	}
}






