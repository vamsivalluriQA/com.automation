package oops;

public abstract class Myabstract 
{
	//properties
	public int x;
	public int y;
	//constructor method
	public Myabstract(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	//operational methods
	public int addition()  //implemented
	{
		int z=x+y;
		return(z);
	}
	public abstract int subtract(); //unimplemented
}
 





