package Seleniumexp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Test81
{
	public static void main(String[] args)
	{
		//Open chrome browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		FluentWait w=new FluentWait(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(1000));
		//Define wait conditions
		ExpectedCondition ec1=ExpectedConditions.elementToBeClickable(By.name("q"));
		ExpectedCondition ec2=ExpectedConditions.attributeToBe(By.name("q"),"title","Search");
		w.until(ExpectedConditions.or(ec1,ec2));
		//close site
		driver.close();
	}
}
