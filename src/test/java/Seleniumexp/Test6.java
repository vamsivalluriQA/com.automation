package Seleniumexp;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test6 
{
	public static void main(String[] args) throws Exception
	{
		//Get browser name from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter browser name");
				String bn=sc.nextLine();
				//Open given browser
				RemoteWebDriver driver; //object declaration to parent class
				if(bn.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
					driver=new ChromeDriver(); //define object using child class constructor method
				}
				else if(bn.equalsIgnoreCase("firefox"))
				{
					System.setProperty("webdriver.gecko.driver","E:\\batch247\\geckodriver.exe");
					driver=new FirefoxDriver(); //define object using child class constructor method
				}
				else if(bn.equalsIgnoreCase("opera"))
				{
					System.setProperty("webdriver.opera.driver",
							                            "E:\\batch247\\operadriver_win64\\operadriver.exe");
					driver=new OperaDriver(); //define object using child class constructor method
				}
				else if(bn.equalsIgnoreCase("ie"))
				{
					//set zoom level to 100% manually
					System.setProperty("webdriver.ie.driver","E:\\batch247\\iedriverserver.exe");
					driver=new InternetExplorerDriver(); //define object using child class constructor method
				}
				else
				{
					EdgeOptions eo=new EdgeOptions();
					//eo.setBinary("C:\\Program Files (x86)\\microsoft\\Edge Beta\\Application\\msedge.exe");
					System.setProperty("webdriver.edge.driver","E:\\batch247\\msedgedriver.exe");
					driver=new EdgeDriver(eo); //object definition to concrete class
				}
		//Launch site(Common code)
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//driver.quit();
	}
}







