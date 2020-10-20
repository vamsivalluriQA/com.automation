package oops;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample5 
{
	//Property
	public ChromeDriver driver;
	//Constructor method
	public Sample5(ChromeDriver driver)
	{
		this.driver=driver;
	}
	//Operational methods
	public void launch(String url)
	{
		driver.get(url);
	}
	
	public void startDrawing()
	{
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.elementToBeClickable(
				               By.xpath("//button[text()='Got It!']"))).click();
	}
	
	public void clearDrawing() throws Exception
	{
		driver.switchTo().frame(0);
		driver.findElement(By.id("trash")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
	}
	
	public void closeSite()
	{
	  	driver.close();
	}
	
	public void drawCircle(Point origin, double radius, int steps) 
	{
	    Point firstPoint=new Point((int)(origin.x+radius),origin.y);
	    PointerInput pi=new PointerInput(PointerInput.Kind.MOUSE,"mouse");
	    Sequence circle=new Sequence(pi,0);
	    circle.addAction(pi.createPointerMove(Duration.ofMillis(20),
                PointerInput.Origin.viewport(),firstPoint.x,firstPoint.y));
	    circle.addAction(pi.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    for (int i=1; i<=steps; i++) //360 degrees
	    {
	    	double theta=2*Math.PI *((double)i/steps);
		    int x=(int)Math.floor(Math.cos(theta)*radius);
		    int y=(int)Math.floor(Math.sin(theta)*radius);
		    Point nextpoint=new Point(origin.x + x,origin.y + y);
	        circle.addAction(pi.createPointerMove(Duration.ofMillis(50),
	                             PointerInput.Origin.viewport(), nextpoint.x, nextpoint.y));
	    }
	    circle.addAction(pi.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	    driver.perform(Arrays.asList(circle));
	}
}





