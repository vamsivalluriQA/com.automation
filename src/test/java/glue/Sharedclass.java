package glue;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.HomePage;

public class Sharedclass {
	
	
	
	public URL u;
	public Scenario s;
	public Properties p;
	public AndroidDriver<MobileElement> driver;
	public HomePage hp;
	
	//common methods
	@Before
	public void mothod1(Scenario s) throws Exception
	{
		this.s=s;
		//load properties file
		FileInputStream fi=new FileInputStream("src\\test\\resources\\utlities\\config.properties");
		p=new Properties();
		p.load(fi);
		//define Driver object
		driver=null;
		//define page class object 
		hp=null;
		//start appium servier 
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
		u =new URL(p.getProperty("appium_server_url"));
	 }
	
	@After
	public void Method() throws Exception 
	{
		//stop appium server 
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
