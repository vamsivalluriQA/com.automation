package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Test102
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Create object to "ListenerBodies" class, which consists of bodies to methods
		ListenerBodies obj=new ListenerBodies();
		//Register "ListenerBodies" to "EventFiringWebDriver"
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		edriver.register(obj);
		//Launch site via navigate
		edriver.navigate().to("http://www.google.co.in");
		Thread.sleep(5000);
		//Close site
		//edriver.close();
		//Unregister  "ListenerBodies" from "EventFiringWebDriver"
		edriver.unregister(obj);

	}

}
