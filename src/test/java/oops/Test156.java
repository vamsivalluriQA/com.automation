package oops;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test156
{
	public static void main(String[] args) throws Exception
	{
		//Open browser 
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vallu\\drivers\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Create object to Reusable class
		Sample5 obj=new Sample5(driver); 
		obj.launch("https://www.groupboard.com/demo/groupboard-online-whiteboard-demo.shtml");
		obj.startDrawing();
		obj.clearDrawing(); //if any existing drawing, goto remove
		Thread.sleep(5000);
		Point headorigin=new Point(450,250);
		Point leftEyeorigin=headorigin.moveBy(-50,-50);
		Point rightEyeorigin=headorigin.moveBy(50,-50);
		Point mouthorigin=headorigin.moveBy(0, 50);
		obj.drawCircle(headorigin,150,70);
		obj.drawCircle(leftEyeorigin, 20, 20);
		obj.drawCircle(rightEyeorigin, 20, 20);
		obj.drawCircle(mouthorigin,40, 20);
		Thread.sleep(5000);
		//clear screen
		obj.clearDrawing();
	    //Close site
	  	obj.closeSite();
	}
}







