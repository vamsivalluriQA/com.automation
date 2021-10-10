package oops;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test166
{
	public static void main(String[] args) 
	{
		//Open browser and avoid browser driver logs
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vallu\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,10);
		w.until(elementFoundAndClicked(By.xpath("//*[text()='Forgot email?']")));
	}
	public static ExpectedCondition<Boolean> elementFoundAndClicked(By locator) 
	{
        return new ExpectedCondition<Boolean>() 
        {
            public Boolean apply(WebDriver driver) 
            {
                WebElement el=driver.findElement(locator);
                el.click();
                return true;
            }
        };
    }
}
