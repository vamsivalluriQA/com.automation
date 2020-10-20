package Seleniumexp;

import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;

public class Test99
{
	public static void main(String[] args)
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch246\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Create DevTools session
		/*DevTools dt=driver.getDevTools();
		dt.createSession();
		HashMap<String, Object> x=new HashMap<>();
        x.put("userAgent","Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");
        driver.executeCdpCommand("Emulation.setUserAgentOverride",x);
		HashMap<String, Object> y=new HashMap<>();
        y.put("width", 375);
        y.put("height", 812);
        y.put("deviceScaleFactor",3);
        y.put("mobile",true);
        y.put("scale",1);
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",y);
		driver.get("https://www.amazon.com");*/
	    
	}
}
