package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test101
{
	public static void main(String[] args)
	{
		//Open browser
		System.out.println("Going to open browser");
		System.setProperty("webdriver.chrome.driver","E:\\batch246\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		System.out.println("Browser opened");
		System.out.println("Going to maximize browser");
		driver.manage().window().maximize();
		System.out.println("Browser maximized");
		//Launch site 
		System.out.println("Going to launch site");
		driver.get("https://the-internet.herokuapp.com/geolocation");
		System.out.println("Site was lauched");
		//Close site
		System.out.println("Going to close browser");
		driver.close();
		System.out.println("browser closed");
	}
}
