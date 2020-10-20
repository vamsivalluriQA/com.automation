package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.Command;
//import org.openqa.selenium.devtools.DevTools;

import com.google.common.collect.ImmutableMap;

public class Test92
{
	public static void main(String[] args)
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch246\\chromedriver.exe");
		ChromeDriver driver1=new ChromeDriver();
		//Create DevTools session
		//DevTools dt=driver1.getDevTools();
		//dt.createSession();
		//Launch site
		driver1.get("http://www.google.co.in");
		//Crash the browser window
		try
		{
			//Command c=new Command("Browser.crash",ImmutableMap.of());
			//dt.send(c);
		}
		catch(Exception ex)
		{
			System.out.println("continue further testing");
		}
		//Open new browser and re-launch site
		ChromeDriver driver2=new ChromeDriver();
		driver2.get("http://www.google.co.in");
	}
}
