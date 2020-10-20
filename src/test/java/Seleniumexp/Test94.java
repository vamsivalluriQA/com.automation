package Seleniumexp;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.network.Network;

import com.google.common.collect.ImmutableList;

public class Test94
{
	public static void main(String[] args)
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Connect to DevTools and create a session
	    /*DevTools dt=driver.getDevTools();
		dt.createSession();
		//enable Network and set blocked URL patterns
		dt.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		dt.send(Network.setBlockedURLs(ImmutableList.of("*.css","*.png","*.jpg")));
		//Launch site
		driver.get("https://www.amazon.com");
		dt.send(Network.disable());*/
	}
}


