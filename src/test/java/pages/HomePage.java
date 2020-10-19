package pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {
	
	public AndroidDriver<MobileElement> driver;
	
	@AndroidFindBy(xpath="//*[@content-desc='minus']")
	public MobileElement minus;
	
	@AndroidFindBy(xpath="//*[@content-desc='plus']")
	public MobileElement plus;
	
	@AndroidFindBy(xpath="//*[@content-desc='divide']")
	public MobileElement divide;
	
	@AndroidFindBy(xpath="//*[@content-desc='multiply']")
	public MobileElement multiply;
	
	@AndroidFindBy(xpath="//*[@content-desc='equals']")
	public MobileElement equals;
	
	@AndroidFindBy(xpath="//*[@content-desc='clear']")
	public MobileElement clear;
	
	@AndroidFindBy(xpath="//*[@resourceid='com.android.calculator2:id/result']")
	public MobileElement outputbox;
	
	public HomePage(AndroidDriver<MobileElement> driver)
	{
		this.driver=driver;
		AppiumFieldDecorator ad=new AppiumFieldDecorator(driver);
		PageFactory.initElements(ad, this);
	}
	
	
	public void clickadd()
	{
		plus.click();
	}
	
	public void clickminus()
	{
		minus.click();
	}
	
	public void clickmultiply()
	{
		multiply.click();
	}
	
	public void clickequals()
	{
		equals.click();
	}
	
	public void clickclear()
	{
		clear.click();
	}
	
	public String getoutput()
	{
		String o=outputbox.getAttribute("text");
		return(o);
	}
	
	

}
