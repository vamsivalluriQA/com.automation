package oops;

public class Myconcrete extends Myabstract
{
	public Myconcrete(int a,int b)
	{
		super(a,b); //call parent class constructor
	}
    //body to unimplemented method of parent class
	public int subtract() 
	{
		int z=super.x-super.y; //call parent class properties
		return(z);
	}
	//Extra methods
	public int mutiply()
	{
		int z=super.x*super.y; //call parent class properties
		return(z);
	}	
}
