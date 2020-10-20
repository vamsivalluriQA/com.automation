package Seleniumexp;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test72
{
	public static void main(String[] args) throws Exception
	{
		//Open chrome browser and launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch246\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goindigo.in");
		Thread.sleep(5000);
		//get details of radio button(pseudo element ::before) before select
		String bc1=(String) driver.executeScript(
               "var ne=document.querySelector('label[for=roundTrip]'); var pe=window.getComputedStyle(ne,'::before'); var x=pe.getPropertyValue('border-color'); return(x);"); 
		String bgc1=(String) driver.executeScript("var y=window.getComputedStyle(document.querySelector('label[for=roundTrip]'),'::before').getPropertyValue('background-color'); return(y);");         
		System.out.println(bc1+" "+bgc1);
		//select a radio button(pseudo element) by clicking on label
		driver.findElement(By.xpath("//*[@for='roundTrip']")).click();
		Thread.sleep(5000);
		//get details of radio button(pseudo element ::before) after select
		String bc2=(String) driver.executeScript("return(window.getComputedStyle(document.querySelector('label[for=roundTrip]'),'::before').getPropertyValue('border-color'));");
		String bgc2=(String) driver.executeScript(
			"var y=window.getComputedStyle(document.querySelector('label[for=roundTrip]'),'::before').getPropertyValue('background-color'); return(y);");
		System.out.println(bc2+" "+bgc2);
		//Close site
		driver.close();
	}
}
