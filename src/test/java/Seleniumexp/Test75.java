package Seleniumexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test75
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser and launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//Search for a word
		driver.findElement(By.name("q")).sendKeys("kalam",Keys.ENTER);
		Thread.sleep(5000);
		//get inner text of page
		String x=(String) driver.executeScript("return(document.documentElement.innerText);");
		System.out.println(x);
		//Define regular expression/pattern matching
		Pattern p=Pattern.compile("[aA][bB][dD][uU][lL][\\s][kK][aA][lL][aA][mM]");
		Matcher m=p.matcher(x);
		int count=0;
		while(m.find())
		{
			count=count+1;
		}
		System.out.println("Count of matches with given word is "+count);
		//Close site
		driver.close();
	}
}
