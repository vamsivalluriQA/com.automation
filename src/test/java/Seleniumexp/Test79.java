package Seleniumexp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test79
{
	public static void main(String[] args)
	{
		//Open chrome browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		FluentWait w=new FluentWait(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(1000));
		//Define wait condition
		ExpectedCondition ec1=
			ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'RadCalendar')]"));
		//Do wait
		w.until(ec1);
		//Get calendar in to visible area of desktop
		WebElement e=driver.findElement(By.xpath("//*[contains(@class,'RadCalendar')]"));
		driver.executeScript("arguments[0].scrollIntoView();",e);
		driver.findElement(By.linkText("6")).click();
		//Define wait condition
		ExpectedCondition ec2=
				ExpectedConditions.visibilityOfElementLocated(By.className("raDiv"));
		//Do wait
		w.until(ExpectedConditions.not(ec2));
		//close site
		driver.close();
	}
}




