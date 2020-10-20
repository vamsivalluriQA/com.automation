package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test12 
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		//Fill fields
		driver.findElement(By.name("firstname")).sendKeys("kalam");
		driver.findElement(By.name("lastname")).sendKeys("abdul");
		driver.findElement(By.name("reg_email__")).sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("reg_passwd__")).sendKeys("wastebatch");
		//Select day
		WebElement d=driver.findElement(By.name("birthday_day"));
		Select s1=new Select(d);
		s1.selectByVisibleText("13");
		//Select month
		WebElement m=driver.findElement(By.name("birthday_month"));
		Select s2=new Select(m);
		s2.selectByVisibleText("Mar");
		//Select year
		WebElement y=driver.findElement(By.name("birthday_year"));
		Select s3=new Select(y);
		s3.selectByVisibleText("1913");
		//fill remaining fields
		driver.findElement(By.xpath("(//input[@name='sex'])[2]")).click();
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("apj@abdulkalam.com");
		Thread.sleep(5000);
		//Click on sign-up
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(5000);
		//Get message
		String msg=driver.findElement(By.id("reg_error_inner")).getText();
		System.out.println(msg);
		//close site
		driver.close();
	}
}





