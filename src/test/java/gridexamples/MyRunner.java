package gridexamples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyRunner
{
	@Parameters({"browser","nodeurl"})
	@Test
	public void method(String bn,String nu) throws Exception
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName(bn);
		URL u=new URL(nu);
		RemoteWebDriver driver=new RemoteWebDriver(u,dc);
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		driver.quit();
	}
}










