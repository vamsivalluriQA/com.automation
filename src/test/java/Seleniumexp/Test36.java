package Seleniumexp;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test36
{
	public static void main(String[] args) throws Exception
	{
		//Open browser and Launch site
		System.setProperty("webdriver.chrome.driver","E:\\batch247\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput","true");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Test case-1: Locate carousel slider
		WebElement cs=driver.findElement(By.id("top-banner"));
		if(cs.getTagName().equals("div"))
		{
			System.out.println("<div> tag based carousel slider is having hidden slides also");
		}
		//Test case-2: Collect all slides in that carousel slider
		List<WebElement> sls=cs.findElements(By.xpath("child::div"));
		int visible=0;
		int hidden=0;
		for(WebElement slide:sls)
		{
			if(slide.getAttribute("class").contains("clone"))
			{
				hidden++;
			}
			else
			{
				visible++;
			}
		}
		System.out.println("Count of visible slides in carousel slider is "+visible);
		System.out.println("Count of hidden slides in carousel slider is "+hidden);
		//Test case-3: Type of carousel slider(3D/2D)
		String x=cs.getCssValue("transform");
		System.out.println("transform property value is "+x);
		if(x.startsWith("matrix3d"))
		{
			System.out.println("3D carousel slider");
		}
		else
		{
			System.out.println("2D carousel slider");
			//start testing on 2D carousel slider
			//Test case-4: direction of slides
			String y=x.substring(7,x.length()-1); //to remove "matrix(" and ")" from value
			String[] z=y.split(","); //split remaining value into pieces using ","
			z[4]=z[4].trim(); //remove spaces from 5th piece(xoffset)
			z[5]=z[5].trim(); //remove spaces from 6th piece(yoffset)
			float xoffset=Float.parseFloat(z[4]); //convert to float
			float yoffset=Float.parseFloat(z[5]); //convert to float
			if(yoffset==0.0 && xoffset>0.0)  //xoffset is +ve
			{
				System.out.println("Left to Right moving slides");
			}
			else if(yoffset==0.0 && xoffset<0.0) //xoffset is -ve
			{
				System.out.println("Right to left moving slides");
			}
			else if(xoffset==0.0 && yoffset>0.0) //yoffset is +ve
			{
				System.out.println("Top to bottom moving slides");
			}
			else //yoffset is -ve
			{
				System.out.println("Bottom to Top moving slides");
			}
			//Test case-5:Find out time delay between slides in carousel slider
			String t=cs.getCssValue("transition");
			System.out.println("transition property value is "+t);
			String[] p=t.split(" "); //split value using space
			System.out.println("Duration of each slide is "+p[1]);
			System.out.println("Delay between slides is "+p[3]);
			if(p[2].equals("ease-in"))
			{
				System.out.println("Slide starts slowly");
			}
			else if(p[2].equals("ease-out"))
			{
				System.out.println("Slide ends slowly");
			}
			else //ease-in-out
			{
				System.out.println("Slide starts and ends slowly");
			}
		} //else ending
		//Close site
		driver.close();
	}
}














