package oops;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Sample4 
{
	//properties
	public RemoteWebDriver driver;
	//Constructor methods
	public Sample4(RemoteWebDriver driver) 
	{
		this.driver=driver;
	}
	//Operational methods
	public void launch(String url)
	{
		driver.get(url);
	}
	
	public String title()
	{
		String x=driver.getTitle();
		return(x);
	}
	public void closeSite()
	{
	  	driver.close();
	}
}









