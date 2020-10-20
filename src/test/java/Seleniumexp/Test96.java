package Seleniumexp;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.security.Security;

public class Test96
{
	public static void main(String[] args)
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Create DevTools session
		/*DevTools dt=driver.getDevTools();
	    dt.createSession();
	    //Activate Security panel
	    dt.send(Security.enable());
        //set to ignore SSL certificate errors
        dt.send(Security.setIgnoreCertificateErrors(true)); 
        //launch insecure web site
        driver.get("https://expired.badssl.com/");
        dt.send(Security.disable());*/
	}
}
