package oops;

public class Rectangle implements Mymath
{
	public float length;
	public float breadth;
	public Rectangle(float length, float breadth)
	{
		this.length=length;
		this.breadth=breadth;
	}
	public float area() 
	{
		float temp=length*breadth;
		return(temp);
	}
	public float perimeter() 
	{
		float temp=(2*length)+(2*breadth);
		return(temp);
	}
}








