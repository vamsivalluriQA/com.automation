package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.console.Console;

public class Test97
{
	public static void main(String[] args)
	{
		//Open chrome browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.google.co.in");
		//Create object to access DevTools and start session
		/*DevTools dt=driver.getDevTools(); //getDevTools() method in "ChromiumDriver"
		dt.createSession();
		//Goto Console and run JavaScript commands through that Console on browser
		dt.send(Console.enable());
		driver.executeScript("console.log('hi');");
		driver.executeScript("console.log(window.scrollTo(0,document.body.scrollHeight));");
		driver.executeScript(
		   "console.log(document.getElementsByName('q')[0].style.border='2px blue dashed');");
		dt.send(Console.disable());*/
	}
}
