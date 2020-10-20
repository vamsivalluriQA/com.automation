package oops;

import org.openqa.selenium.chrome.ChromeDriver;

public class Sample3 
{
	public int x;
	public float y;
	public boolean z;
	public String s;
	public int[] a;
	public ChromeDriver driver;
	//Constructor methods
	public Sample3()   //constructor without arguments
	{
		x=10;
		y=(float) 20.0;
		z=true;
	}
	public Sample3(int p) //constructor with int argument
	{
		x=p;
		y=(float) 20.0;
		a=new int[]{12,23,34,45};
	}
	public Sample3(float p)  //constructor with float argument
	{
		x=10;
		y=p;
		s="steve jobs";
	}
	public Sample3(int p, float q) //constructor with int and float arguments
	{
		x=p;
		y=q;
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





