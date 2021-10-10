package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hidewithheadbrowser1
{
	public static void main(String[] args)
	{


		//Hide with head browser and launch site
		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeOptions co=new ChromeOptions();
		co.setHeadless(true);  //default is false
		ChromeDriver driver=new ChromeDriver(co); //common logic for all browsers
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
		String x=driver.getTitle();
		System.out.println(x);
		driver.close();
	}
}


