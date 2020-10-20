package Seleniumexp;

//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test42
{
	public static void main(String[] args) throws Exception
	{
		//open browser and launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get new Browser window
		//driver.switchTo().newWindow(WindowType.TAB);
	}
}






