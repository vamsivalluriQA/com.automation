package Seleniumexp;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.performance.Performance;
//import org.openqa.selenium.devtools.performance.model.Metric;

public class Test98
{
	public static void main(String[] args)
	{
		//Open browser
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Create DevTools session
		/*DevTools dt=driver.getDevTools();
	    dt.createSession();
	    dt.send(Performance.enable());
        driver.get("https://www.amazon.com");
        List<Metric> ms=dt.send(Performance.getMetrics());
        for(Metric m:ms)
        {
        	System.out.println(m.getName()+"="+m.getValue());
        }
        dt.send(Performance.disable());*/
	}
}





