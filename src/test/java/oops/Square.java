package oops;

public class Square implements Mymath
{
	public float edge;
	
	public Square(float edge)
	{
		this.edge=edge;
	}
	public float area() 
	{
		float temp=edge*edge;
		return(temp);
	}

	public float perimeter() 
	{
		float temp=4*edge;
		return(temp);
	}
}
