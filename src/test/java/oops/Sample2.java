package oops;

import org.openqa.selenium.chrome.ChromeDriver;

public class Sample2 
{
	//Data members(Properties)
	public int x;
	public float y;
	public boolean z;
	public String s;
	public int[] a;
	public ChromeDriver driver;
	//Constructor method
	public Sample2()
	{
		x=10;
		y=(float) 20.0;
		s="kalam";
	}
	//Operational method
	public void display()
	{
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(s);
		System.out.println(a);
		System.out.println(driver);
	}
}





