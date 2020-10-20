package Seleniumexp;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test34
{
	public static void main(String[] args) throws Exception
	{
		//Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word to search");
		String word=sc.nextLine();
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Enter a word in search box to get cache/auto-complete
		driver.findElement(By.name("q")).sendKeys(word); //Parameterization
		Thread.sleep(5000);
		//Test case-1:Locate cache/auto-complete element and collect all suggestions in it
		WebElement cache=driver.findElement(By.xpath("//ul[@role='listbox']"));
		List<WebElement> suggestions=cache.findElements(By.xpath("child::li"));
		System.out.println("Count of suggestions is "+suggestions.size());
		System.out.println("Suggestions are:");
		for(WebElement suggestion:suggestions)
		{
			System.out.println(suggestion.getText());
		}
		//Test case-2:check each suggestion, which contains given word or not
		int flag=0;
		for(WebElement suggestion:suggestions)
		{
			if(!suggestion.getText().contains(word))
			{
				flag=1;
			}
		} //loop ending
		if(flag==0)
		{
			System.out.println("Cache is correct for given "+word);
		}
		else
		{
			System.out.println("Cache is wrong for given "+word);
		}
		//Test case-3:Each suggestion selection testing
		for(WebElement suggestion:suggestions)
		{
			//1. get text of suggestion to be selected
			String expected=suggestion.getText();
			//2. Down arrow to select suggestion
			driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
			//3. Get selected suggestion text
			String actual=driver.findElement(By.name("q")).getAttribute("value");
			//4.compare both expected and actual
			if(expected.equals(actual))
			{
				System.out.println("\""+expected+"\" suggestion selection test passed");
			}
			else
			{
				System.out.println("\""+expected+"\" suggestion selection test failed");
			}
			Thread.sleep(2000);
		}
		//close site
		driver.close();
	}
}
