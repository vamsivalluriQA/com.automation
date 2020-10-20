package Seleniumexp;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test45
{
	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		//minimize browser window
		//driver.manage().window().minimize(); //added in SWD 4 alpha-5
		Thread.sleep(5000);
		//maximize browser window
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get width and height
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(w+" "+h);
		//Get position of browser window on desktop
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+" "+y);
		//Change size
		Dimension d=new Dimension(200,300);
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Change position
		Point p=new Point(100,400);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//full screen of browser window
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}











