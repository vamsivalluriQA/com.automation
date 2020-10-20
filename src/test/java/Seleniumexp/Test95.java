package Seleniumexp;

import java.util.HashMap;
import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.network.Network;

public class Test95
{
	public static void main(String[] args)
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Connect to DevTools and create a session
		/*DevTools dt=driver.getDevTools();
		dt.createSession();
		dt.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
		HashMap<String, Object> x=new HashMap<>();
        x.put("timezoneId","Antarctica/Casey");
        driver.executeCdpCommand("Emulation.setTimezoneOverride",x);
        driver.get("https://momentjs.com/");
        dt.send(Network.disable());*/
	}
}
