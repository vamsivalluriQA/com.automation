package oops;

public interface Sample7
{
	//Properties
	public static int x=10;   //static property with initialized value
	public final int y=20;  //non-static property as final with constant value
	//No constructor method concept
	//Operational static methods with bodies
	public static void subtraction()
	{
		System.out.println(y-x);
	}
	//Operational non-static methods declarations(no bodies)
	public void addition();
}





