package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Thread.sleep(5000);
		//get browser window handle number
		String x=driver.getWindowHandle();
		System.out.println(x);
	}
}
