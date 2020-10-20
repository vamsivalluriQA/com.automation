package oops;

//Singleton class
public class Sample8 
{
	//properties
	public int x;
	public int y;
	//private Constructor method
	private Sample8(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	//Operational methods
	public static Sample8 initate(int a, int b)
	{
		Sample8 obj=new Sample8(a,b);
		return(obj);
	}
	
	public int addition()
	{
		int z=x+y;
		return(z);
	}
	
	

}








